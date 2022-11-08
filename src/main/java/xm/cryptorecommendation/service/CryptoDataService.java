package xm.cryptorecommendation.service;

import org.springframework.http.ResponseEntity;
import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;


public interface CryptoDataService {

    void clear();
    ResponseEntity<?> listAllWithOldestPrice();

    ResponseEntity<?>  listAllWithNewestPrice();

    ResponseEntity<?> listAllWithMinPrice();

    ResponseEntity<?> listAllWithMaxPrice();
}
