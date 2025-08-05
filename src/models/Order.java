package models;

public class Order {
    private String orderId;
    private Product product;
    private int quantity;
    private boolean fulfilled;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.fulfilled = false;
    }

    public String getOrderId() { return orderId; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public boolean isFulfilled() { return fulfilled; }

    public void markFulfilled() { this.fulfilled = true; }

    @Override
    public String toString() {
        return "Order " + orderId + ": " + quantity + " x " + product.getName() + " (Fulfilled: " + fulfilled + ")";
    }
}
