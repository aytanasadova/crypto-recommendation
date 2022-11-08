package xm.cryptorecommendation.service;

import org.springframework.http.ResponseEntity;
import xm.cryptorecommendation.domain.CryptoData;

import java.time.LocalDate;
import java.util.List;


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
    ResponseEntity<?>  getByMaxNormalizedPriceByDate(LocalDate date);

}
