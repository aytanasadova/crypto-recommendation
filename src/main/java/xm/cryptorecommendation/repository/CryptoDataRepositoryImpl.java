package xm.cryptorecommendation.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xm.cryptorecommendation.domain.CryptoData;
import xm.cryptorecommendation.helper.QuerySource;

import java.time.LocalDate;
import java.util.List;


/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@Repository
public class CryptoDataRepositoryImpl implements CryptoDataRepository {

    private  final  JdbcTemplate jdbcTemplate;

    public CryptoDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void clear() {
        jdbcTemplate.execute(QuerySource.TRUNCATE_CRYPTO_DATA);
    }


    @Override
    public List<CryptoData> listAllWithOldestPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_OLDEST_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }
    @Override
    public List<CryptoData> listAllWithOldestPrice(LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_OLDEST_PRICE_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class),beginInterval,endInterval);
    }

    @Override
    public List<CryptoData> listAllWithNewestPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_NEWEST_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }
    @Override
    public List<CryptoData> listAllWithNewestPrice(LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_NEWEST_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class),beginInterval,endInterval);
    }
    @Override
    public List<CryptoData> listAllWithMinPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MIN_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }
    @Override
    public List<CryptoData> listAllWithMinPrice(LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MIN_PRICE_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class),beginInterval,endInterval);
    }

    @Override
    public List<CryptoData> listAllWithMaxPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MAX_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }
    @Override
    public List<CryptoData> listAllWithMaxPrice(LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_MAX_PRICE_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class),beginInterval,endInterval);
    }

    @Override
    public List<CryptoData> listAllWithNormalizedPrice() {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_NORMALIZED_PRICE, new BeanPropertyRowMapper<>(CryptoData.class));
    }
    @Override
    public List<CryptoData> listAllWithNormalizedPrice(LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.query(QuerySource.LIST_ALL_WITH_NORMALIZED_PRICE_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class),beginInterval,endInterval);
    }

    @Override
    public CryptoData getMinPriceByCryptoName(String name) {
        return jdbcTemplate.queryForObject(QuerySource.GET_MIN_PRICE_FOR_CRYPTO, new BeanPropertyRowMapper<>(CryptoData.class), name);
    }
    @Override
    public CryptoData getMinPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.queryForObject(QuerySource.GET_MIN_PRICE_FOR_CRYPTO_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class), name,beginInterval,endInterval);
    }
    @Override
    public CryptoData getMaxPriceByCryptoName(String name) {
        return jdbcTemplate.queryForObject(QuerySource.GET_MAX_PRICE_FOR_CRYPTO, new BeanPropertyRowMapper<>(CryptoData.class), name);
    }
    @Override
    public CryptoData getMaxPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.queryForObject(QuerySource.GET_MAX_PRICE_FOR_CRYPTO_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class), name,beginInterval,endInterval);
    }

    @Override
    public CryptoData getOldestPriceByCryptoName(String name) {
        return jdbcTemplate.queryForObject(QuerySource.GET_OLDEST_PRICE_FOR_CRYPTO, new BeanPropertyRowMapper<>(CryptoData.class), name);
    }

    @Override
    public CryptoData getOldestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.queryForObject(QuerySource.GET_OLDEST_PRICE_FOR_CRYPTO_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class), name,beginInterval,endInterval);
    }

    @Override
    public CryptoData getNewestPriceByCryptoName(String name) {
        return jdbcTemplate.queryForObject(QuerySource.GET_NEWEST_PRICE_FOR_CRYPTO, new BeanPropertyRowMapper<>(CryptoData.class), name);
    }
    @Override
    public CryptoData getNewestPriceByCryptoName(String name,LocalDate beginInterval,LocalDate endInterval) {
        return jdbcTemplate.queryForObject(QuerySource.GET_NEWEST_PRICE_FOR_CRYPTO_BY_INTERVAL, new BeanPropertyRowMapper<>(CryptoData.class), name,beginInterval,endInterval);
    }

    @Override
    public CryptoData getByMaxNormalizedPriceByDate(LocalDate date) {
        List<CryptoData> resultList = jdbcTemplate.query(QuerySource.LIST_BY_MAX_NORMALIZED_PRICE_BY_DATE, new BeanPropertyRowMapper<>(CryptoData.class), date);
        return getFirstElementOfList(resultList);
    }


    private CryptoData getFirstElementOfList(List<CryptoData> resultList) {
        return (resultList == null || resultList.isEmpty()) ? null : resultList.stream().findFirst().get();
    }

}
