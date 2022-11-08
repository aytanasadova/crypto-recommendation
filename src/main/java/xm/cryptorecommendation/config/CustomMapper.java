package xm.cryptorecommendation.config;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import xm.cryptorecommendation.domain.CryptoData;

import org.springframework.validation.BindException;

 ;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class CustomMapper implements FieldSetMapper<CryptoData> {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static  Integer counter=1;
    @Override
    public CryptoData mapFieldSet(FieldSet fieldSet) throws BindException {

        CryptoData cryptoData = new CryptoData();
        cryptoData.setId(counter++);
        cryptoData.setPrice(fieldSet.readBigDecimal("price"));
        cryptoData.setSymbol(fieldSet.readString("symbol"));
        cryptoData.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(fieldSet.readLong("timestamp")),TimeZone.getDefault().toZoneId()));
        return cryptoData;
    }
}