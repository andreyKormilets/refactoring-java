package domain;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<MovieRental> rentals;

    public Order(Customer customer, List<MovieRental> rentals) {
        this.rentals = rentals;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MovieRental> getRentals() {
        return rentals;
    }
}
