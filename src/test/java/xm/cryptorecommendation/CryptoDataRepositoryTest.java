package xm.cryptorecommendation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import xm.cryptorecommendation.domain.CryptoData;
import xm.cryptorecommendation.repository.CryptoDataRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CryptoDataRepositoryTest {

    @Mock
    private CryptoDataRepository cryptoDataRepository;

    private CryptoData cryptoData;


    @BeforeEach
    public void setup() {

        cryptoData = new CryptoData();
        cryptoData.setPrice(new BigDecimal("123124.5353"));
        cryptoData.setSymbol("BTC");
        cryptoData.setTimestamp(LocalDateTime.ofInstant(Instant.ofEpochMilli(1641009600000L), TimeZone.getDefault().toZoneId()));

    }


    @DisplayName("JUnit test for getByMaxNormalizedPriceByDate method")
    @Test()
    public void givenLocalDate_whenCallMethod_thenReturnCryptoDataObject() {

        given(cryptoDataRepository.getByMaxNormalizedPriceByDate(LocalDate.of(2030, 11, 11)))
                .willReturn(cryptoData);
        // when
        CryptoData result = cryptoDataRepository.getByMaxNormalizedPriceByDate(LocalDate.of(2030, 11, 11));
        // then
        assertThat(result).isNotNull();
        assertThat(result).isInstanceOf(CryptoData.class);
    }

}
