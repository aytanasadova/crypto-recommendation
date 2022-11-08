package xm.cryptorecommendation.repository;

import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;


public interface CryptoDataRepository {

    void clear();

    List<CryptoData> listAllWithOldestPrice();

    List<CryptoData> listAllWithNewestPrice();

    List<CryptoData> listAllWithMinPrice();

    List<CryptoData> listAllWithMaxPrice();
}
