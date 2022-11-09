package xm.cryptorecommendation.repository;

import xm.cryptorecommendation.domain.CryptoData;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
public interface CryptoDataRepository {

    void clear();

    List<CryptoData> listAllWithOldestPrice();

    List<CryptoData> listAllWithNewestPrice();

    List<CryptoData> listAllWithMinPrice();

    List<CryptoData> listAllWithMaxPrice();
    List<CryptoData> listAllWithNormalizedPrice();
    CryptoData  getMinPriceByCryptoName(String name);
    CryptoData  getMaxPriceByCryptoName(String name);
    CryptoData  getOldestPriceByCryptoName(String name);
    CryptoData  getNewestPriceByCryptoName(String name);
    CryptoData  getByMaxNormalizedPriceByDate(LocalDate date);

}
