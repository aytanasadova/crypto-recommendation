package xm.cryptorecommendation.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;


public interface CryptoDataService {
    List<CryptoData> listAll();
}
