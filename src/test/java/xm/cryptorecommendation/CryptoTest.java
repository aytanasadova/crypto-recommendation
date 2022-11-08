package xm.cryptorecommendation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xm.cryptorecommendation.domain.Crypto;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CryptoTest {

    private  final Crypto crypto=new Crypto(1,"BTC");


    @Test
    void shouldPrintCrypto() {
       assertEquals("Crypto{id=1, name='BTC'}",crypto.toString());
    }
}
