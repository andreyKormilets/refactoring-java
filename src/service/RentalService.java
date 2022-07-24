package service;

import domain.Order;

public interface RentalService {
    String getStatement(Order order);
}
