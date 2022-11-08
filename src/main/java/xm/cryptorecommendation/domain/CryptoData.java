package xm.cryptorecommendation.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CryptoData {

    private LocalDateTime timestamp;
    private BigDecimal price;
    private String symbol;
    public CryptoData() {
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

    @Override
    public String toString() {
        return "CryptoData{" +
                "timestamp=" + timestamp +
                ", price=" + price +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
