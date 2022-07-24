package service;

import domain.Movie;
import domain.MovieRental;
import domain.Order;
import exception.CanNotCreateStatementException;
import exception.MovieNotFoundException;
import repository.MoviesFinder;

import static enums.FilmsGroup.NEW;

public class RentalServiceImpl implements RentalService {

    private final MoviesFinder moviesFinder;

    public RentalServiceImpl(MoviesFinder moviesFinder) {
        this.moviesFinder = moviesFinder;
    }

    @Override
    public String getStatement(Order order) throws CanNotCreateStatementException {

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + order.getCustomer().getName() + "\n");
        for (MovieRental rental : order.getRentals()) {
            Movie currentMovie;
            try {
                currentMovie = moviesFinder.getMovieById(rental.getMovieId());
            } catch (MovieNotFoundException e) {
                throw new CanNotCreateStatementException("MovieNotFoundException");
            }
            double thisFilmAmount = currentMovie.getFilmsGroup().getMultiplier(rental.getDays());
            frequentEnterPoints++;
            if (rental.getDays() > 2 && currentMovie.getFilmsGroup() == NEW)
                frequentEnterPoints++;
            result.append("\t").append(currentMovie.getTitle()).append("\t").append(thisFilmAmount).append("\n");
            totalAmount = totalAmount + thisFilmAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");

        return result.toString();

    }

}
