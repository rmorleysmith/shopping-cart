public class CartItem {

    private final Product product;
    private int quantity;

    public CartItem(Product inputProduct, int inputQuantity) {
        this.product = inputProduct;
        this.quantity = inputQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
