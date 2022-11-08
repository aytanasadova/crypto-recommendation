package xm.cryptorecommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xm.cryptorecommendation.domain.CryptoData;
import xm.cryptorecommendation.repository.CryptoDataRepository;

import java.util.List;
@Service
public class CryptoDataServiceImp implements CryptoDataService {
    @Autowired
    CryptoDataRepository cryptoDataRepository;

    @Override
    public List<CryptoData> listAll() {
        return cryptoDataRepository.listAll();
    }
    public  void dropTable(){
        cryptoDataRepository.dropTable();
    }

}
