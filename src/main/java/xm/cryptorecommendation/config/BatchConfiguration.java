package xm.cryptorecommendation.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import xm.cryptorecommendation.domain.CryptoData;
import xm.cryptorecommendation.listener.CustomJobExecutionListener;
import xm.cryptorecommendation.mapper.CustomFieldSetMapper;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * <h1>Batching configurations</h1>
 * @see <a href="https://spring.io/projects/spring-batch">Spring batch</a>
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final CustomJobExecutionListener listener;
    @Value("${csv.resource}")
    private String csvResource;

    /**
     * Injection of necessary dependencies
     * @param jobBuilderFactory
     * @param stepBuilderFactory
     * @param dataSource
     * @param listener
     */
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource, CustomJobExecutionListener listener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
        this.listener = listener;
    }

    /**
     * Writes data that gathered from csv files to database
     * @return
     */
    @Bean
    public JdbcBatchItemWriter<CryptoData> writer() {
        JdbcBatchItemWriter<CryptoData> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO CRYPTO_DATA (timestamp, symbol, price) VALUES (:timestamp, :symbol, :price)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return itemWriter;
    }

    /**
     * reader: The ItemReader that provides items for processing.
     * @return
     */
    @Bean
    public Job readFromCSVFile() {
        return jobBuilderFactory
                .get("readFromCSVFile")
                .incrementer(new RunIdIncrementer()).listener(listener)
                .start(step1())
                .build();
    }

    /**
     * Domain object that encapsulates an independent, sequential phase of a batch job
     * and contains all the information necessary to define and control the actual batch processing.
     * To aim this step is load data from a file into the database
     *
     * @return Step
     */
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<CryptoData, CryptoData>chunk(100)
                .reader(multiResourceItemReader())
                .writer(writer())
                .build();
    }

    /**
     * Reads from multiple csv files
     * In case of directory not exists, this will be an error state
     * @return
     */
    @Bean
    public MultiResourceItemReader<CryptoData> multiResourceItemReader() {
        MultiResourceItemReader<CryptoData> resourceItemReader = new MultiResourceItemReader<>();
        resourceItemReader.setResources(loadResourcesFromDirectory());
        resourceItemReader.setDelegate(reader());
        resourceItemReader.setStrict(true);
        return resourceItemReader;
    }

    @Bean
    public FlatFileItemReader<CryptoData> reader() {

        FlatFileItemReader<CryptoData> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {   {    setNames("timestamp", "symbol", "price");     }
                });
                setFieldSetMapper(new CustomFieldSetMapper());
            }
        });
        return reader;
    }

    /**
     * Private method to load files from resource
     * @return
     */
    private Resource[] loadResourcesFromDirectory() {
        ClassLoader cl = this.getClass().getClassLoader();
        try {
            return  new PathMatchingResourcePatternResolver(cl).getResources(csvResource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
