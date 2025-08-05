package models;

public class Product {
    private String productId;
    private String name;
    private String location;
    private int quantity;

    public Product(String productId, String name, String location, int quantity) {
        this.productId = productId;
        this.name = name;
        this.location = location;
        this.quantity = quantity;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough stock for " + name);
        }
    }

    @Override
    public String toString() {
        return name + " (ID: " + productId + ", Location: " + location + ", Qty: " + quantity + ")";
    }
}
