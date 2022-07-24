package service;

import domain.Order;
import exception.CanNotCreateStatementException;

public interface RentalService {
    String getStatement(Order order) throws  CanNotCreateStatementException;
}
