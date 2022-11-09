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
    ResponseEntity<?> listAllWithOldestPrice(LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> listAllWithNewestPrice();
    ResponseEntity<?> listAllWithNewestPrice(LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> listAllWithMinPrice();
    ResponseEntity<?> listAllWithMinPrice(LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> listAllWithMaxPrice();
    ResponseEntity<?> listAllWithMaxPrice(LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> listAllWithNormalizedPrice();
    ResponseEntity<?> listAllWithNormalizedPrice(LocalDate beginInterval,LocalDate endInterval);

    ResponseEntity<?> getMinPriceByCryptoName(String name);
    ResponseEntity<?> getMinPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> getMaxPriceByCryptoName(String name);
    ResponseEntity<?> getMaxPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);

    ResponseEntity<?> getOldestPriceByCryptoName(String name);
    ResponseEntity<?> getOldestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    ResponseEntity<?> getNewestPriceByCryptoName(String name);
    ResponseEntity<?> getNewestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);

    ResponseEntity<?> getByMaxNormalizedPriceByDate(LocalDate date);

}
