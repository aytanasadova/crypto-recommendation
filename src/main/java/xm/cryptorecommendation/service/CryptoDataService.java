package xm.cryptorecommendation.service;

import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;


public interface CryptoDataService {
    List<CryptoData> listAll();

    void dropTable();
}
