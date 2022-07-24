package service;


import domain.Customer;
import domain.MovieRental;
import domain.Order;
import exception.CanNotCreateStatementException;
import org.junit.jupiter.api.Assertions;
import repository.MoviesFinder;
import repository.MoviesFinderImpl;

import java.util.Arrays;
import java.util.List;

class RentalServiceImplTest {

    @org.junit.jupiter.api.Test
    void getStatement() throws CanNotCreateStatementException {

        MoviesFinder moviesFinder = new MoviesFinderImpl();
        RentalService rentalService = new RentalServiceImpl(moviesFinder);
        Customer customer = new Customer("C. U. Stomer");
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        Order order = new Order(customer, rentals);

        String result = rentalService.getStatement(order);
        String expected =
                "Rental Record for C. U. Stomer\n" +
                "\tYou've Got Mail\t3.5\n" +
                "\tMatrix\t2.0\n" +
                "Amount owed is 5.5\n" +
                "You earned 2 frequent points\n";
        Assertions.assertEquals(expected, result);

        rentals = Arrays.asList(new MovieRental("F003", 6), new MovieRental("F004", 8));
        order = new Order(customer, rentals);
        result = rentalService.getStatement(order);
        expected =
                "Rental Record for C. U. Stomer\n" +
                "\tCars\t6.0\n" +
                "\tFast & Furious X\t24.0\n" +
                "Amount owed is 30.0\n" +
                "You earned 3 frequent points\n";
        Assertions.assertEquals(expected, result);

    }
    @org.junit.jupiter.api.Test
    void getStatementError() {

        MoviesFinder moviesFinder = new MoviesFinderImpl();
        RentalService rentalService = new RentalServiceImpl(moviesFinder);
        Customer customer = new Customer("C. U. Stomer");
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F008", 3), new MovieRental("F002", 1));
        Order order = new Order(customer, rentals);


        Assertions.assertThrows(CanNotCreateStatementException.class, () -> {
            String result= rentalService.getStatement(order);
        });

    }
}