package repository;

import domain.Movie;

public interface MoviesRepository {
    Movie getMovieById(String id);
}
