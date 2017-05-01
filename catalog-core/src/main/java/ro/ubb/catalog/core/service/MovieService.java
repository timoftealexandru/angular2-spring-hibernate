package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Movie;

import java.util.List;


/**
 * Created by Nicu on 4/9/17.
 */
public interface MovieService {

    List<Movie> getAllMovies();

    Movie createMovie(String name, String director, String genre, Integer availableCopies);

    Movie updateMovie(Long movieID,String name, String director, String genre, Integer availableCopies);

    void deleteMovie(Long movieID);
}