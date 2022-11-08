//package xm.cryptorecommendation.config;
//
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.stereotype.Component;
//import xm.cryptorecommendation.domain.CryptoData;
//
//@Component
//public class CustomCSVReader extends FlatFileItemReader<CryptoData> implements ItemReader<CryptoData> {
//
//    public CustomCSVReader() {
//        setResource(new FileSystemResource("C:\\files\\BTC_values.csv"));
//        setLinesToSkip(1);
//        setLineMapper(getDefaultLineMapper());
//    }
//
//    public DefaultLineMapper<CryptoData> getDefaultLineMapper() {
//        DefaultLineMapper<CryptoData> defaultLineMapper = new DefaultLineMapper<CryptoData>();
//        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
//        delimitedLineTokenizer.setNames(new String[]{"timestamp", "symbol", "price"});
//        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
//
//        BeanWrapperFieldSetMapper<CryptoData> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<CryptoData>();
//        beanWrapperFieldSetMapper.setTargetType(CryptoData.class);
//        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//
//        return defaultLineMapper;
//    }
//}