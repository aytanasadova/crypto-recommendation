package xm.cryptorecommendation.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import xm.cryptorecommendation.domain.CryptoData;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 * @return FieldSetMapper
 */
public class CustomFieldSetMapper implements FieldSetMapper<CryptoData> {

    /**
     * To map fields
     *
     * @param fieldSet the {@link FieldSet} to map
     * @return CryptoData with mapped data
     */
    @Override
    public CryptoData mapFieldSet(FieldSet fieldSet) {
        return mapFieldsToCryptoDataObject(fieldSet);
    }


    private CryptoData mapFieldsToCryptoDataObject(FieldSet fieldSet) {
        CryptoData cryptoData = new CryptoData();
        cryptoData.setPrice(fieldSet.readBigDecimal("price"));
        cryptoData.setSymbol(fieldSet.readString("symbol"));
        cryptoData.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(fieldSet.readLong("timestamp")), TimeZone.getDefault().toZoneId()));
        return cryptoData;
    }
}