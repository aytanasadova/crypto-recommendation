package xm.cryptorecommendation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xm.cryptorecommendation.domain.CryptoData;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class CryptoDataTest {

    private static final CryptoData cryptoData=new CryptoData();

    @BeforeAll
    static void intCryptoData() {
        cryptoData.setPrice(new BigDecimal("123124.5353"));
        cryptoData.setSymbol("BTC");
        cryptoData.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(1641009600000L), TimeZone.getDefault().toZoneId()));
    }
    @Test

    void shouldPrintCryptoData() {
        System.out.println(cryptoData);
        assertEquals("CryptoData{timestamp=2022-01-01T05:00, price=123124.535300000003189779818058013916015625, symbol='BTC'}", cryptoData.toString());
    }


}
