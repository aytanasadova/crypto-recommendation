package xm.cryptorecommendation.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@CacheConfig(cacheNames = "CryptoDataServiceCache")
@Cacheable
public interface CryptoDataService {

    void clear();

    ResponseEntity<?> listAllWithOldestPrice();

    ResponseEntity<?> listAllWithNewestPrice();

    ResponseEntity<?> listAllWithMinPrice();

    ResponseEntity<?> listAllWithMaxPrice();

    ResponseEntity<?> listAllWithNormalizedPrice();

    ResponseEntity<?> getMinPriceByCryptoName(String name);

    ResponseEntity<?> getMaxPriceByCryptoName(String name);

    ResponseEntity<?> getOldestPriceByCryptoName(String name);

    ResponseEntity<?> getNewestPriceByCryptoName(String name);

    ResponseEntity<?> getByMaxNormalizedPriceByDate(LocalDate date);

}
