package xm.cryptorecommendation.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CryptoData {
    int id;
    private LocalDateTime timestamp;

    private BigDecimal price;

    private String symbol;

    public CryptoData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CryptoData)) return false;
        CryptoData that = (CryptoData) o;
        return getTimestamp().equals(that.getTimestamp()) && getPrice().equals(that.getPrice()) && getSymbol().equals(that.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimestamp(), getPrice(), getSymbol());
    }
    //    private long timestamp;
//    private Double price;
//
//    private String symbol;
//
//    public CryptoData() {
//    }
//
//    public CryptoData(long timestamp, Double price, String symbol) {
//        this.timestamp = timestamp;
//        this.price = price;
//        this.symbol = symbol;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }
//
//    @Override
//    public String toString() {
//        return "CryptoData{" +
//                "timestamp=" + timestamp +
//                ", price=" + price +
//                ", symbol='" + symbol + '\'' +
//                '}';
//    }
}
