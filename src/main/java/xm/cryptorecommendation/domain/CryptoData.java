package xm.cryptorecommendation.domain;


public class CryptoData {

    private long timestamp;
    private Double price;

    private String symbol;

    public CryptoData() {
    }

    public CryptoData(long timestamp, Double price, String symbol) {
        this.timestamp = timestamp;
        this.price = price;
        this.symbol = symbol;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "CryptoData{" +
                "timestamp=" + timestamp +
                ", price=" + price +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
