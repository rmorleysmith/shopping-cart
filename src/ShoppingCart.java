import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private BigDecimal totalPrice;
    private final List<CartItem> cartItemList;

    public ShoppingCart() {
        this.totalPrice = new BigDecimal(0);
        this.cartItemList = new ArrayList<>();
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    private void setTotalPrice(BigDecimal newTotalPrice) {
        this.totalPrice = newTotalPrice;
    }

    public int getTotalItems() {
        int totalItems = 0;

        //Loop through the cart items and add the quantities on each
        for (CartItem cartItem : this.cartItemList) totalItems += cartItem.getQuantity();

        return totalItems;
    }

    public void addItem(Product product, int quantity) {
        this.cartItemList.add(new CartItem(product, quantity));
        this.refreshTotalPrice();
    }

    public void removeQuantityOfProduct(Product product, int quantity) {
        CartItem cartItem;
        int currentQuantity;
        int cartIndex = this.getIndexOfProductInCart(product);

        // Make sure we have found the cart item
        if (cartIndex != -1) {
            cartItem = this.cartItemList.get(cartIndex);
            currentQuantity = cartItem.getQuantity();
        } else {
            System.out.println("Product not found in shopping cart");
            return;
        }

        this.setQuantityOnCartItem(cartItem, cartIndex, currentQuantity - quantity);
        this.refreshTotalPrice();
    }

    private void refreshTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;

        // Loop through the cart items and add up the values
        for (CartItem cartItem : this.cartItemList) {
            Product product = cartItem.getProduct();
            total = total.add(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
        }

        this.setTotalPrice(total);
    }

    private int getIndexOfProductInCart(Product product) {
        int cartIndex = -1;

        // Loop through the cart items and check for a matching product
        for (int i = 0; i < this.cartItemList.size(); ++i) {
            if (this.cartItemList.get(i).getProduct() == product) {
                cartIndex = i;
                break;
            }
        }

        return cartIndex;
    }

    private void setQuantityOnCartItem(CartItem cartItem, int cartIndex, int newQuantity) {

        if (newQuantity < 0) {
            this.cartItemList.remove(cartIndex);
        } else {
            cartItem.setQuantity(newQuantity);
        }

    }

}
