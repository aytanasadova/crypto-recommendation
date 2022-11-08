package xm.cryptorecommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xm.cryptorecommendation.repository.CryptoDataRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CryptoDataServiceImp implements CryptoDataService {
    @Autowired
    CryptoDataRepository cryptoDataRepository;

    @Override
    public ResponseEntity<?> listAllWithOldestPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithOldestPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithNewestPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithNewestPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithMinPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithMinPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithMaxPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithMaxPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithNormalizedPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithNormalizedPrice());
    }


    @Override
    public ResponseEntity<?> getMinPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getMinPriceByCryptoName(name));
    }

    @Override
    public ResponseEntity<?> getMaxPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getMaxPriceByCryptoName(name));
    }

    @Override
    public ResponseEntity<?> getOldestPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getOldestPriceByCryptoName(name));
    }

    @Override
    public ResponseEntity<?> getNewestPriceByCryptoName(String name) {
        System.out.println("88888");
        return generateResponseWithObject(cryptoDataRepository.getNewestPriceByCryptoName(name));
    }

    @Override
    public ResponseEntity<?> getByMaxNormalizedPriceByDate(LocalDate date) {
        System.out.println("9999");
        return generateResponseWithObject(cryptoDataRepository.getByMaxNormalizedPriceByDate(date));
    }

    private ResponseEntity<?> generateResponseWithList(List<?> resultList) {
        return (resultList == null || resultList.isEmpty()) ? new ResponseEntity<>(resultList, HttpStatus.NO_CONTENT) : new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    private ResponseEntity<?> generateResponseWithObject(Object result) {
        return result == null ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT) : new ResponseEntity<>(result, HttpStatus.OK);
    }

    public void clear() {
        cryptoDataRepository.clear();
    }
}
