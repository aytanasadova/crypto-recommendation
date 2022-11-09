package xm.cryptorecommendation.helper;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
public class QuerySource {

    public static final String TRUNCATE_CRYPTO_DATA = "TRUNCATE  TABLE CRYPTO_DATA";
    public static final String LIST_ALL_WITH_OLDEST_PRICE = "select   d. timestamp, d.symbol, d.price from  crypto_data d  " +
            " join  (SELECT   symbol, min(timestamp) timestamp  FROM CRYPTO_DATA  group by symbol ) cc on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";


    public static final String LIST_ALL_WITH_NEWEST_PRICE = " select   d. timestamp, d.symbol, d.price from  crypto_data d  " +
            " join  (SELECT   symbol, min(timestamp) timestamp  FROM CRYPTO_DATA  group by symbol ) cc on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";

    public static final String LIST_ALL_WITH_MAX_PRICE = "SELECT symbol, max(price)  price FROM CRYPTO_DATA  group by symbol ;";

    public static final String LIST_ALL_WITH_MIN_PRICE = "SELECT symbol, min(price)  price FROM CRYPTO_DATA  group by symbol ;";


    public static final String LIST_ALL_WITH_NORMALIZED_PRICE = "select(max(price)-min(price))/min(price) price, symbol  from crypto_data group by symbol order by price desc;";

    public static final String GET_MIN_PRICE_FOR_CRYPTO = "SELECT symbol, min(price)  price FROM CRYPTO_DATA  where symbol=? group by symbol;";

    public static final String GET_MAX_PRICE_FOR_CRYPTO = "SELECT symbol, max(price)  price FROM CRYPTO_DATA  where symbol=? group by symbol;";

    public static final String GET_OLDEST_PRICE_FOR_CRYPTO = "select d. timestamp, d.symbol, d.price from  crypto_data d  " +
            " join (SELECT symbol, min(timestamp) timestamp  FROM CRYPTO_DATA  where symbol=? group by symbol ) cc  " +
            " on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";
    public static final String GET_NEWEST_PRICE_FOR_CRYPTO = "select d. timestamp, d.symbol, d.price from  crypto_data d  " +
            "join (SELECT symbol, max(timestamp) timestamp  FROM CRYPTO_DATA  where symbol=? group by symbol ) cc" +
            " on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";

    public static final String LIST_BY_MAX_NORMALIZED_PRICE_BY_DATE = " select (max(price)-min(price))/min(price) price,symbol from crypto_data  where  DATE_TRUNC(DAY, timestamp) =?  group by symbol  order by price desc ";


}
