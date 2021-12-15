import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;

    private final Product apple = new Product("APPLE", ProductType.APPLE, new BigDecimal("2.35"));
    private final Product pear = new Product("PEAR", ProductType.PEAR, new BigDecimal("3.87"));
    private final Product orange = new Product("ORANGE", ProductType.ORANGE, new BigDecimal("1.37"));

    @BeforeEach
    void setUp() {
        this.shoppingCart = new ShoppingCart();
    }

    @Test
    void addItemShouldIncreaseTotalItems() {

        shoppingCart.addItem(apple, 1);

        assertEquals(1, shoppingCart.getTotalItems());

    }

    @Test
    void addMultipleItemsShouldIncreaseTotalItems() {

        shoppingCart.addItem(apple, 1);
        shoppingCart.addItem(orange, 2);
        shoppingCart.addItem(pear, 3);

        assertEquals(6, shoppingCart.getTotalItems());

    }

    @Test
    void getTotalPriceShouldReturnTotalCartValue() {

        shoppingCart.addItem(pear, 2);
        shoppingCart.addItem(orange, 3);

        assertEquals(0 ,shoppingCart.getTotalPrice().compareTo(BigDecimal.valueOf(11.85)));

    }

    @Test
    void removeQuantityOfProductShouldReduceTotalQuantity() {

        shoppingCart.addItem(pear, 2);
        shoppingCart.addItem(orange, 3);

        shoppingCart.removeQuantityOfProduct(pear, 2);

        assertEquals(3, shoppingCart.getTotalItems());

    }

    @Test
    void removeQuantityOfProductShouldReduceTotalCartValue() {

        shoppingCart.addItem(pear, 2);
        shoppingCart.addItem(orange, 3);

        shoppingCart.removeQuantityOfProduct(pear, 1);

        assertEquals(0 ,shoppingCart.getTotalPrice().compareTo(BigDecimal.valueOf(7.98)));

    }

}
