package xm.cryptorecommendation.config;


import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;
@Component
public class CustomCSVWriter<T> implements ItemWriter<CryptoData> {

    @Override
    public void write(List<? extends CryptoData> list) throws Exception {
        for (CryptoData data : list) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getTimestamp() + " : " + data.getSymbol() + " : " + data.getPrice());
        }
    }
}
