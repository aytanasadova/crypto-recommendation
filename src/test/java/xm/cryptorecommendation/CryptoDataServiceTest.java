package xm.cryptorecommendation;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xm.cryptorecommendation.service.CryptoDataService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Ignore
public class CryptoDataServiceTest {

    @Autowired
    private CryptoDataService cryptoDataService;


    @Test
    void savedUserHasRegistrationDate() {
        assertNotEquals(null,cryptoDataService.getByMaxNormalizedPriceByDate(LocalDate.now()).getBody());
    }


}
