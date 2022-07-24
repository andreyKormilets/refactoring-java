package repository;

import domain.Movie;
import exception.MovieNotFoundException;

public interface MoviesFinder {
    Movie getMovieById(String id) throws MovieNotFoundException;
}
