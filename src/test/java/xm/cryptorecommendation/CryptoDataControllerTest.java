package xm.cryptorecommendation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CryptoDataControllerTest {
    @Autowired
    private MockMvc mvc;
    String basePath = "/crypto-data/";

    @Test
    public void listAllWithOldestPrice() throws Exception {
        String uri = basePath + "/withOldestPrice/";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").isNotEmpty());
        ;
    }

    @Test
    public void listAllWithNewestPrice() throws Exception {
        String uri = basePath + "/withNewestPrice/";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").isNotEmpty());
        ;
    }


    @Test
    public void listAllWithMinPrice() throws Exception {
        String uri = basePath + "/withMinPrice/";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").isNotEmpty());
        ;
    }


    @Test
    public void listAllWithMaxPrice() throws Exception {
        String uri = basePath + "/withMaxPrice/";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").isNotEmpty());
        ;
    }


    @Test
    public void listAllWithNormalizedPrice() throws Exception {
        String uri = basePath + "/withNormalizedPrice/";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].symbol").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].price").isNotEmpty());
        ;
    }


    @Test
    public void shouldSuccessGetMinPriceByCryptoName() throws Exception {
        String uri = basePath + "/minPriceByCryptoName/{name}";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "BTC")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").value("BTC"));
    }


    @Test
    public void shouldFailGetMinPriceByCryptoName() throws Exception {
        String uri = basePath + "/minPriceByCryptoName/{name}";

        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "nonExistCrypto")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldSuccessGetMaxPriceByCryptoName() throws Exception {
        String uri = basePath + "/maxPriceByCryptoName/{name}";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "BTC")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").value("BTC"));
    }


    @Test
    public void shouldFailGetMaxPriceByCryptoName() throws Exception {
        String uri = basePath + "/maxPriceByCryptoName/{name}";

        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "nonExistCrypto")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldSuccessGetOldestPriceByCryptoName() throws Exception {
        String uri = basePath + "/oldestPriceByCryptoName/{name}";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "BTC")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").value("BTC"));
    }


    @Test
    public void shouldFailGetOldestPriceByCryptoName() throws Exception {
        String uri = basePath + "/oldestPriceByCryptoName/{name}";

        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "nonExistCrypto")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldSuccessGetNewestPriceByCryptoName() throws Exception {
        String uri = basePath + "/newestPriceByCryptoName/{name}";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "BTC")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").value("BTC"));
    }


    @Test
    public void shouldFailGetNewestPriceByCryptoName() throws Exception {
        String uri = basePath + "/newestPriceByCryptoName/{name}";

        mvc.perform(MockMvcRequestBuilders
                        .get(uri, "nonExistCrypto")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldSuccessByMaxNormalizedPriceByDate() throws Exception {
        String uri = basePath + "/byMaxNormalizedPrice/date/{date}";
        mvc.perform(MockMvcRequestBuilders
                        .get(uri, LocalDate.of(3000,12,12))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
}
