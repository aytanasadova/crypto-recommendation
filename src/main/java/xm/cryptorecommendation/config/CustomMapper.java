package xm.cryptorecommendation.config;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import xm.cryptorecommendation.domain.CryptoData;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


public class CustomMapper implements FieldSetMapper<CryptoData> {

    @Override
    public CryptoData mapFieldSet(FieldSet fieldSet)   {

        CryptoData cryptoData = new CryptoData();
        cryptoData.setPrice(fieldSet.readBigDecimal("price"));
        cryptoData.setSymbol(fieldSet.readString("symbol"));
        cryptoData.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(fieldSet.readLong("timestamp")),TimeZone.getDefault().toZoneId()));
        return cryptoData;
    }
}