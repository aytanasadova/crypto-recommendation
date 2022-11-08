package xm.cryptorecommendation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xm.cryptorecommendation.domain.Crypto;
import xm.cryptorecommendation.domain.CryptoData;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CryptoDataRepositoryImpl implements CryptoDataRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CryptoData> listAll() {
        List<CryptoData> c=jdbcTemplate.query("SELECT * FROM CRYPTO_DATA",new BeanPropertyRowMapper<>(CryptoData.class));
        System.out.println("yyyyyyy"+c);
        return   c;
//        return null;
    }

    @Override
    public List<CryptoData> listAllByNormalizedRange() {
        return null;
    }

    @Override
    public List<CryptoData> getMinPriceForEachDuringMonth() {
        return null;
    }

    @Override
    public List<CryptoData> getMaxPriceForEachDuringMonth() {
        return null;
    }

    @Override
    public List<CryptoData> getNewestPriceForEachDuringMonth() {
        return null;
    }

    @Override
    public List<CryptoData> getOldestPriceForEachDuringMonth() {
        return null;
    }

    @Override
    public List<CryptoData> getMinPriceForEachDuringMonth(Crypto crypto) {
        return null;
    }

    @Override
    public List<CryptoData> getMaxPriceForEachDuringMonth(Crypto crypto) {
        return null;
    }

    @Override
    public List<CryptoData> getNewestPriceForEachDuringMonth(Crypto crypto) {
        return null;
    }

    @Override
    public List<CryptoData> getOldestPriceForEachDuringMonth(Crypto crypto) {
        return null;
    }

    @Override
    public CryptoData getWithHighestNormalizedRangeByDate(LocalDate date) {
        return null;
    }


}
