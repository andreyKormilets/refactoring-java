package service;

import domain.Movie;
import domain.MovieRental;
import domain.Order;
import repository.MoviesRepository;

import static enums.FilmsGroup.NEW;

public class RentalServiceImpl implements RentalService {

    MoviesRepository moviesRepository;

    public RentalServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Override
    public String getStatement(Order order) {

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + order.getCustomer().getName() + "\n");
        for (MovieRental rental : order.getRentals()) {
            Movie currentMovie = moviesRepository.getMovieById(rental.getMovieId());
            double thisFilmAmount = currentMovie.getFilmsGroup().priceMultiplier.apply(rental.getDays());

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
