package ro.ubb.catalog.web.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Movie;
import ro.ubb.catalog.web.dto.MovieDto;

/**
 * Created by paul on 4/29/2017.
 */
@Component
public class MovieConverter extends  BaseConverter<Movie, MovieDto> {
    private static final Logger log = LoggerFactory.getLogger(MovieConverter.class);

    @Override
    public MovieDto convertModelToDto(Movie movie){

        MovieDto movieDto = new MovieDto(movie.getName(), movie.getDirector(),movie.getGenre(), movie.getAvailableCopies());
        movieDto.setId(movie.getId());

        return movieDto;

    }
}
