import java.math.BigDecimal;

public class Product {

    private final String code;
    private final ProductType type;
    private final BigDecimal price;

    public Product(String productCode, ProductType productType, BigDecimal productPrice) {
        this.code = productCode;
        this.type = productType;
        this.price = productPrice;
    }

    public String getCode() {
        return this.code;
    }

    public ProductType getType() {
        return this.type;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

}
