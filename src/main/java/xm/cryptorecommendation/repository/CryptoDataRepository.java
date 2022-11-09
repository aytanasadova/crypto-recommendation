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
    List<CryptoData> listAllWithOldestPrice(LocalDate beginInterval,LocalDate endInterval);

    List<CryptoData> listAllWithNewestPrice();
    List<CryptoData> listAllWithNewestPrice(LocalDate beginInterval,LocalDate endInterval);
    List<CryptoData> listAllWithMinPrice();
    List<CryptoData> listAllWithMinPrice(LocalDate beginInterval,LocalDate endInterval);
    List<CryptoData> listAllWithMaxPrice();
    List<CryptoData> listAllWithMaxPrice(LocalDate beginInterval,LocalDate endInterval);
    List<CryptoData> listAllWithNormalizedPrice();
    List<CryptoData> listAllWithNormalizedPrice(LocalDate beginInterval,LocalDate endInterval);
    CryptoData  getMinPriceByCryptoName(String name);
    CryptoData  getMinPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    CryptoData  getMaxPriceByCryptoName(String name);
    CryptoData  getMaxPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    CryptoData  getOldestPriceByCryptoName(String name);
    CryptoData  getOldestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    CryptoData  getNewestPriceByCryptoName(String name);
    CryptoData  getNewestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval);
    CryptoData  getByMaxNormalizedPriceByDate(LocalDate date);

}
