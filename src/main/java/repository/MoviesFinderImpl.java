package repository;

import domain.Movie;
import exception.MovieNotFoundException;

import java.util.HashMap;

import static enums.FilmsGroup.*;

public class MoviesFinderImpl implements MoviesFinder {
    private final HashMap<String, Movie> movies;

    public MoviesFinderImpl() {
        this.movies = new HashMap<>();
        movies.put("F001", new Movie("You've Got Mail", REGULAR));
        movies.put("F002", new Movie("Matrix", REGULAR));
        movies.put("F003", new Movie("Cars", CHILDRENS));
        movies.put("F004", new Movie("Fast & Furious X", NEW));
    }

    @Override
    public Movie getMovieById(String id) throws  MovieNotFoundException {
        if (!movies.containsKey(id)) throw  new MovieNotFoundException();
        return movies.get(id);
    }
}
