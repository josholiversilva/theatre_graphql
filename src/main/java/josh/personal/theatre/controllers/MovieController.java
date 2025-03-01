package josh.personal.theatre.controllers;

import josh.personal.theatre.models.Movie;
import josh.personal.theatre.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    @QueryMapping
    public Optional<Movie> movieById(@Argument String id) {
        return movieService.getMovieById(id);
    }

    @MutationMapping
    public Movie createMovie(@Argument String userId, String name, String genre, String director) {
        Movie movie = movieService.createMovie(userId, name, genre, director);
        movieService.cacheMovie(movie);

        return movie;
    }
}
