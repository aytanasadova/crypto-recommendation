package xm.cryptorecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class CryptoRecommendationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoRecommendationApplication.class, args);
    }

}
