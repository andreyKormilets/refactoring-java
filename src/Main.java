import domain.Customer;
import domain.MovieRental;
import domain.Order;
import repository.MoviesRepository;
import repository.MoviesRepositoryImpl;
import service.RentalService;
import service.RentalServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        MoviesRepository moviesRepository = new MoviesRepositoryImpl();
        RentalService rentalService = new RentalServiceImpl(moviesRepository);
        Customer customer = new Customer("C. U. Stomer");
        List<MovieRental> rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        Order order = new Order(customer, rentals);

        String result = rentalService.getStatement(order);


        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

        // String result = new RentalInfo().statement(new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

        if (!result.equals(expected)) {
            throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
        }

        System.out.println("Success");
    }


}
