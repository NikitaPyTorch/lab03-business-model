package by.bseu.pp.lab03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order and protects the allowed order state transitions.
 */
public class Order {
    private final Customer customer;
    private final List<OrderItem> items;
    private OrderStatus status;
    private Payment payment;

    public Order(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getItemsCount() {
        return items.size();
    }

    public Payment getPayment() {
        return payment;
    }

    public void addItem(Product product, int quantity) {
        requireStatus(OrderStatus.CREATED);
        items.add(new OrderItem(product, quantity));
    }

    public double total() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getAmount();
        }
        return total;
    }

    public void confirm() {
        requireStatus(OrderStatus.CREATED);
        if (items.isEmpty()) {
            throw new IllegalStateException("An empty order cannot be confirmed");
        }
        if (!customer.canPlaceOrder(total())) {
            throw new IllegalStateException("Customer is inactive or credit limit is exceeded");
        }
        status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (status != OrderStatus.CREATED && status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException("Only a created or confirmed order can be cancelled");
        }
        status = OrderStatus.CANCELLED;
    }

    public void pay(Payment payment) {
        requireStatus(OrderStatus.CONFIRMED);
        if (payment == null) {
            throw new IllegalArgumentException("Payment must not be null");
        }
        if (!payment.isSuccessful()) {
            throw new IllegalStateException("Payment must be successful");
        }
        if (Double.compare(payment.getAmount(), total()) != 0) {
            throw new IllegalArgumentException("Payment amount must equal the order total");
        }
        this.payment = payment;
        status = OrderStatus.PAID;
    }

    public boolean isPaid() {
        return status == OrderStatus.PAID;
    }

    private void requireStatus(OrderStatus expected) {
        if (status != expected) {
            throw new IllegalStateException("Expected order status " + expected + ", actual " + status);
        }
    }
}
