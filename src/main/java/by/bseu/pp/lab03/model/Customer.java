package by.bseu.pp.lab03.model;

/**
 * Represents a customer of the enterprise.
 *
 * <p>Validates customer data and controls order eligibility.</p>
 */
public class Customer {
    private final String code;
    private String name;
    private boolean active;
    private double creditLimit;

    public Customer(String code, String name, double creditLimit) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Customer code must not be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be blank");
        }
        if (!Double.isFinite(creditLimit) || creditLimit < 0) {
            throw new IllegalArgumentException("Credit limit must be finite and non-negative");
        }
        this.code = code;
        this.name = name;
        this.creditLimit = creditLimit;
        this.active = true;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be blank");
        }
        this.name = newName;
    }

    public void changeCreditLimit(double newCreditLimit) {
        if (!Double.isFinite(newCreditLimit) || newCreditLimit < 0) {
            throw new IllegalArgumentException("Credit limit must be finite and non-negative");
        }
        this.creditLimit = newCreditLimit;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean canPlaceOrder(double orderTotal) {
        if (!Double.isFinite(orderTotal) || orderTotal < 0) {
            throw new IllegalArgumentException("Order total must be finite and non-negative");
        }
        return active && orderTotal <= creditLimit;
    }
}
