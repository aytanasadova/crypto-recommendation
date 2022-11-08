package xm.cryptorecommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xm.cryptorecommendation.domain.CryptoData;
import xm.cryptorecommendation.repository.CryptoDataRepository;

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


    private ResponseEntity<?> generateResponseWithList(List<?> resultList ){
        return resultList.isEmpty()?new ResponseEntity<>(resultList, HttpStatus.NO_CONTENT):new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    public  void clear(){
        cryptoDataRepository.clear();
    }
}
