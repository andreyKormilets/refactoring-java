package repository;

import domain.Movie;

import java.util.HashMap;

import static enums.FilmsGroup.*;

public class MoviesRepositoryImpl implements MoviesRepository {
    private final HashMap<String, Movie> movies;

    public MoviesRepositoryImpl() {
        this.movies = new HashMap<>();
        movies.put("F001", new Movie("You've Got Mail", REGULAR));
        movies.put("F002", new Movie("Matrix", REGULAR));
        movies.put("F003", new Movie("Cars", CHILDRENS));
        movies.put("F004", new Movie("Fast & Furious X", NEW));
    }

    @Override
    public Movie getMovieById(String id) {
        return movies.get(id);
    }
}
