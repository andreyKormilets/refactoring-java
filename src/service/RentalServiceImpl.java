package service;

import domain.Movie;
import domain.MovieRental;
import domain.Order;
import enums.FilmsGroup;
import repository.MoviesRepository;

import java.util.HashMap;

import static enums.FilmsGroup.NEW;

public class RentalServiceImpl implements  RentalService {

    MoviesRepository moviesRepository;

    public RentalServiceImpl(MoviesRepository moviesRepository){
        this.moviesRepository=moviesRepository;
    }

    @Override
    public String getStatement(Order order) {

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        String result = "Rental Record for " + order.getCustomer().getName() + "\n";
        for (MovieRental rental :   order.getRentals()) {
            Movie currentMovie = moviesRepository.getMovieById(rental.getMovieId());
            double thisFilmAmount = currentMovie.getFilmsGroup().priceMultiplier.apply(rental.getDays());

            frequentEnterPoints++;
            if (rental.getDays() > 2&& moviesRepository.getMovieById(rental.getMovieId()).getFilmsGroup() == NEW )
                frequentEnterPoints++;
            result += "\t" + currentMovie.getTitle() + "\t" + thisFilmAmount + "\n";
            totalAmount = totalAmount +thisFilmAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentEnterPoints + " frequent points\n";

        return result;

    }


}
