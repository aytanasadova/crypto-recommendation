package xm.cryptorecommendation.helper;

public class QuerySource {

    public static final String TRUNCATE_CRYPTO_DATA="TRUNCATE  TABLE CRYPTO_DATA";
    public static final String LIST_ALL_WITH_OLDEST_PRICE=" select   d. timestamp, d.symbol, d.price from  crypto_data d  " +
            " join  (SELECT   symbol, min(timestamp) timestamp  FROM CRYPTO_DATA  group by symbol ) cc on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";


    public static final String LIST_ALL_WITH_NEWEST_PRICE=" select   d. timestamp, d.symbol, d.price from  crypto_data d  " +
            " join  (SELECT   symbol, min(timestamp) timestamp  FROM CRYPTO_DATA  group by symbol ) cc on cc.timestamp=d.timestamp and cc.symbol=d.symbol;";

    public static final String LIST_ALL_WITH_MAX_PRICE="SELECT symbol, max(price)  price FROM CRYPTO_DATA  group by symbol ;";

    public static final String LIST_ALL_WITH_MIN_PRICE="SELECT symbol, min(price)  price FROM CRYPTO_DATA  group by symbol ;";

}
