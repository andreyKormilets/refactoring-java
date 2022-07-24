package repository;

import domain.Movie;

import java.util.HashMap;

public interface MoviesRepository {
     Movie  getMovieById(String id);
}
