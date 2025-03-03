package josh.personal.theatre.services;

import josh.personal.theatre.cache.LRU;
import josh.personal.theatre.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    private LRU lru;

    public Optional<Movie> getMovieById(@Argument UUID id) {
        return lru.get(id);
    }

    public void cacheMovie(Movie movie) {
        lru.add(movie);
    }

    public Movie createMovie(String name, String genre, String director) {
        return Movie.builder()
                .id(UUID.randomUUID())
                .name(name)
                .genre(genre)
                .director(director)
                .timestamp(LocalTime.now().toString())
                .build();
    }
}
