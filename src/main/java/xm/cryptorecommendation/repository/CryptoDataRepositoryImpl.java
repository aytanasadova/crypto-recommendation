package xm.cryptorecommendation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xm.cryptorecommendation.helper.QuerySource;
import xm.cryptorecommendation.domain.CryptoData;

import java.util.List;

@Repository
public class CryptoDataRepositoryImpl implements CryptoDataRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void clear() {
        jdbcTemplate.execute(QuerySource.TRUNCATE_CRYPTO_DATA);
    }

    @Override
    public List<CryptoData> listAllWithOldestPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_OLDEST_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }

    @Override
    public List<CryptoData> listAllWithNewestPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_NEWEST_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }

    @Override
    public List<CryptoData> listAllWithMinPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MIN_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }

    @Override
    public List<CryptoData> listAllWithMaxPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MAX_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }

}
