package by.bseu.pp.lab03.model;

/**
 * Represents a product sold by the enterprise.
 */
public class Product {
    private final String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Product code must not be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name must not be blank");
        }
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("Price must be finite and non-negative");
        }
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Product name must not be blank");
        }
        this.name = newName;
    }

    public void changePrice(double newPrice) {
        if (!Double.isFinite(newPrice) || newPrice < 0) {
            throw new IllegalArgumentException("Price must be finite and non-negative");
        }
        this.price = newPrice;
    }

    public double calculateAmount(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        return price * quantity;
    }
}
