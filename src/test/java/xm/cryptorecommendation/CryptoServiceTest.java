package xm.cryptorecommendation;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xm.cryptorecommendation.domain.Crypto;
import xm.cryptorecommendation.domain.CryptoData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Ignore
public class CryptoServiceTest {
  private final List<CryptoData> cryptoDataList = new ArrayList<>();
//
//    @BeforeAll
//    void initCryptoDataList() {
//        cryptoDataList.add(new CryptoData(new Crypto(1, "BTC"), 1641009600000L, new BigDecimal(46813.21), "USD"));
//        cryptoDataList.add(new CryptoData(new Crypto(2, "DOGE"), 1641009600000L, new BigDecimal(0.1702), "USD"));
//        cryptoDataList.add(new CryptoData(new Crypto(1, "ETH"), 1641009600000L, new BigDecimal(2387), "USD"));
//        cryptoDataList.add(new CryptoData(new Crypto(1, "LTC"), 1641009600000L, new BigDecimal(148.1), "USD"));
//        cryptoDataList.add(new CryptoData(new Crypto(1, "XRP"), 1640995200000L, new BigDecimal(0.8298), "USD"));
//    }



}
