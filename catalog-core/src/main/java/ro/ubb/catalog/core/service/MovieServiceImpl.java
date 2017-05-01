package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.core.repository.MovieRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Nicu on 4/9/17.
 */
@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);


    @Autowired
    private MovieRepository movieRepository;


    @Override
    @Transactional
    public Movie createMovie(String name, String director, String genre, Integer availableCopies){
        log.trace("updateMovieService: movieName= {}", name);

        Movie movie = new Movie(name,director,genre,availableCopies);
        movie = movieRepository.save(movie);

        log.trace("updateMovieService: movie", movie);

        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        log.trace("findAllService --- method entered");

        List<Movie> movies = movieRepository.findAll();

        log.trace("findAllService: movies={}", movies);

        return movies;
    }


    @Override
    public void deleteMovie(Long movieID){

        log.trace("deleteMovieService --- method entered");

        movieRepository.delete(movieID);

        log.trace("deleteMovieService: movie={}", movieID);

    }

    @Override
    @Transactional
    public Movie updateMovie(Long movieID, String name, String director, String genre, Integer availableCopies){

        log.trace("updateMovieService --- method entered");

        Movie movie =movieRepository.findOne(movieID);
        movie.setGenre(genre);
        movie.setDirector(director);
        movie.setName(name);
        movie.setAvailableCopies(availableCopies);

        log.trace("updateMovieService: movie={}", movie);

        return movie;
    }
}
