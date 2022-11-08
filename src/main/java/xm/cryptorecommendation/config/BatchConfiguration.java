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

import javax.sql.DataSource;
import java.io.IOException;

/**
 * <h1>Add Two Numbers!</h1>
 * The AddNum program implements an application that
 * simply adds two given integer numbers and Prints
 * the output on the screen.
 * <p>
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author  Zara Ali
 * @version 1.0
 * @since   2014-03-31
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    private final JobBuilderFactory jobBuilderFactory;

    private final  StepBuilderFactory stepBuilderFactory;

    private   final DataSource dataSource;


    private final  Listener listener;

    @Value("${csv.resource}")
    private String csvResource;

    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource, Listener listener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
        this.listener = listener;
    }

    @Bean
    public JdbcBatchItemWriter<CryptoData> writer() {
        JdbcBatchItemWriter<CryptoData> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO CRYPTO_DATA (timestamp, symbol, price) VALUES (:timestamp, :symbol, :price)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return itemWriter;
    }

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer()).listener(listener)
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<CryptoData, CryptoData>chunk(100)
                .reader(multiResourceItemReader())
                .writer(writer())
                .build();
    }

    @Bean
    public MultiResourceItemReader<CryptoData> multiResourceItemReader() {
        MultiResourceItemReader<CryptoData> resourceItemReader = new MultiResourceItemReader<>();
            resourceItemReader.setResources(loadResourcesFromDirectory());
            resourceItemReader.setDelegate(reader());
            resourceItemReader.setStrict(true);
        return resourceItemReader;
    }

    private Resource[] loadResourcesFromDirectory() {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        try {
            return resolver.getResources(csvResource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FlatFileItemReader<CryptoData> reader() {

        FlatFileItemReader<CryptoData> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames("timestamp", "symbol", "price");
//                        setNames(new String[]{"timestamp", "symbol", "price"});
                    }
                });
                setFieldSetMapper(new CustomMapper());
            }
        });
        return reader;
    }
}
