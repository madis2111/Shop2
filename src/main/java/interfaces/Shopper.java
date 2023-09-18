package interfaces;

public interface Shopper {
    boolean addToCart(Product product, int amount);

    boolean removeFromCart(Product product, int amountToDelete);
}
