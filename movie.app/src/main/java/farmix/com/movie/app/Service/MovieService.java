package farmix.com.movie.app.Service;

import farmix.com.movie.app.Repo.MoviesRepository;
import farmix.com.movie.app.movies.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movie> allMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movie> getMovieById(String imdbId) {
        return moviesRepository.findByImdbId(imdbId);
    }
}
