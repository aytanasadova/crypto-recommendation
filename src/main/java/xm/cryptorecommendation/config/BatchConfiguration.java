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
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import xm.cryptorecommendation.domain.CryptoData;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    DataSource dataSource;
    @Bean
    public JdbcBatchItemWriter<CryptoData> writer() {
        JdbcBatchItemWriter<CryptoData> itemWriter = new JdbcBatchItemWriter<CryptoData>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO CRYPTO_DATA (timestamp, symbol, price) VALUES (:timestamp, :symbol, :price)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CryptoData>());
        return itemWriter;
    }

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
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
        MultiResourceItemReader<CryptoData> resourceItemReader = new MultiResourceItemReader<CryptoData>();
        String directoryPath = "file:C:/files/*.csv";
        resourceItemReader.setResources(loadResourcesFromDirectory(directoryPath));
        resourceItemReader.setDelegate(reader());
        return resourceItemReader;
    }

    private Resource[] loadResourcesFromDirectory(String directoryPath) {
        ClassLoader cl = this.getClass().getClassLoader();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        try {
            return resolver.getResources(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public FlatFileItemReader<CryptoData> reader() {
        //Create reader instance
        FlatFileItemReader<CryptoData> reader = new FlatFileItemReader<CryptoData>();

        //Set number of lines to skips. Use it if file has header rows.
        reader.setLinesToSkip(1);

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper() {
            {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"timestamp", "symbol", "price"});
                    }
                });
                //Set values in Employee class
                setFieldSetMapper(new BeanWrapperFieldSetMapper<CryptoData>() {
                    {
                        setTargetType(CryptoData.class);
                    }
                });
            }
        });
        return reader;
    }

}
