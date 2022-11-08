//package xm.cryptorecommendation.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import xm.cryptorecommendation.domain.CryptoData;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    CustomCSVReader customCSVReader;
//
//    @Autowired
//    CustomCSVWriter customCSVWriter;
//
//
//    @Bean
//    public Job createJob() {
//        return jobBuilderFactory.get("MyJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(createStep()).end().build();
//    }
//
//    @Bean
//    public Step createStep() {
//        return stepBuilderFactory.get("MyStep")
//                .<CryptoData, CryptoData> chunk(1)
//                .reader(customCSVReader)
//                .writer(customCSVWriter)
//                .build();
//    }
//
//
//}
