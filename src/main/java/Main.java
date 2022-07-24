import domain.Customer;
import domain.MovieRental;
import domain.Order;
import exception.CanNotCreateStatementException;
import repository.MoviesFinder;
import repository.MoviesFinderImpl;
import service.RentalService;
import service.RentalServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MoviesFinder moviesFinder = new MoviesFinderImpl();
        RentalService rentalService = new RentalServiceImpl(moviesFinder);
        Customer customer = new Customer("C. U. Stomer");
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        Order order = new Order(customer, rentals);

        String result = null;
        try {
            result = rentalService.getStatement(order);
        } catch (CanNotCreateStatementException e) {
           System.out.println(e.getMessage());
        }
        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

        if (!result.equals(expected)) {
            throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
        }

        System.out.println("Success");
    }


}
