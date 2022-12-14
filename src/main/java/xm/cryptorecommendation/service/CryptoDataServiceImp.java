package xm.cryptorecommendation.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xm.cryptorecommendation.repository.CryptoDataRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@Service
public class CryptoDataServiceImp implements CryptoDataService {
    private final CryptoDataRepository cryptoDataRepository;

    public CryptoDataServiceImp(CryptoDataRepository cryptoDataRepository) {
        this.cryptoDataRepository = cryptoDataRepository;
    }

    @Override
    public ResponseEntity<?> listAllWithOldestPrice(LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithList(cryptoDataRepository.listAllWithOldestPrice(beginInterval,endInterval));
    }
    @Override
    public ResponseEntity<?> listAllWithOldestPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithOldestPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithNewestPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithNewestPrice());
    }
    @Override
    public ResponseEntity<?> listAllWithNewestPrice(LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithList(cryptoDataRepository.listAllWithNewestPrice(beginInterval,endInterval));
    }
    @Override
    public ResponseEntity<?> listAllWithMinPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithMinPrice());
    }
    @Override
    public ResponseEntity<?> listAllWithMinPrice(LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithList(cryptoDataRepository.listAllWithMinPrice(beginInterval,endInterval));
    }

    @Override
    public ResponseEntity<?> listAllWithMaxPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithMaxPrice());
    }
    @Override
    public ResponseEntity<?> listAllWithMaxPrice(LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithList(cryptoDataRepository.listAllWithMaxPrice(beginInterval,endInterval));
    }
    @Override
    public ResponseEntity<?> listAllWithNormalizedPrice() {
        return generateResponseWithList(cryptoDataRepository.listAllWithNormalizedPrice());
    }

    @Override
    public ResponseEntity<?> listAllWithNormalizedPrice(LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithList(cryptoDataRepository.listAllWithNormalizedPrice(beginInterval,endInterval));
    }

    @Override
    public ResponseEntity<?> getMinPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getMinPriceByCryptoName(name));
    }
    @Override
    public ResponseEntity<?> getMinPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithObject(cryptoDataRepository.getMinPriceByCryptoName(name,beginInterval,endInterval));
    }
    @Override
    public ResponseEntity<?> getMaxPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getMaxPriceByCryptoName(name));
    }
    @Override
    public ResponseEntity<?> getMaxPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithObject(cryptoDataRepository.getMaxPriceByCryptoName(name,beginInterval,endInterval));
    }
    @Override
    public ResponseEntity<?> getOldestPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getOldestPriceByCryptoName(name));
    }
    @Override
    public ResponseEntity<?> getOldestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithObject(cryptoDataRepository.getOldestPriceByCryptoName(name,beginInterval,endInterval));
    }

    @Override
    public ResponseEntity<?> getNewestPriceByCryptoName(String name) {
        return generateResponseWithObject(cryptoDataRepository.getNewestPriceByCryptoName(name));
    }
    @Override
    public ResponseEntity<?> getNewestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return generateResponseWithObject(cryptoDataRepository.getNewestPriceByCryptoName(name,beginInterval,endInterval));
    }

    @Override
    public ResponseEntity<?> getByMaxNormalizedPriceByDate(LocalDate date) {
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
