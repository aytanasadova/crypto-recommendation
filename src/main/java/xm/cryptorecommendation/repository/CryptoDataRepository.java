package xm.cryptorecommendation.repository;

import org.springframework.stereotype.Repository;
import xm.cryptorecommendation.domain.Crypto;
import xm.cryptorecommendation.domain.CryptoData;

import java.time.LocalDate;
import java.util.List;


public interface CryptoDataRepository {

    List<CryptoData> listAll();

    //  Exposes an endpoint that will return a descending sorted list of all the cryptos,
    //comparing the normalized range (i.e. (max-min)/min)
    List<CryptoData> listAllByNormalizedRange();

    //Calculates oldest/newest/min/max for each crypto for the whole month
    List<CryptoData> getMinPriceForEachDuringMonth();

    List<CryptoData> getMaxPriceForEachDuringMonth();

    List<CryptoData> getNewestPriceForEachDuringMonth();

    List<CryptoData> getOldestPriceForEachDuringMonth();

//    Exposes an endpoint that will return the oldest/newest/min/max values for a requested
//    crypto

    List<CryptoData> getMinPriceForEachDuringMonth(Crypto crypto);

    List<CryptoData> getMaxPriceForEachDuringMonth(Crypto crypto);

    List<CryptoData> getNewestPriceForEachDuringMonth(Crypto crypto);

    List<CryptoData> getOldestPriceForEachDuringMonth(Crypto crypto);


//    ● Exposes an endpoint that will return the crypto with the highest normalized range for a
//    specific day

    CryptoData getWithHighestNormalizedRangeByDate(LocalDate date);
}
