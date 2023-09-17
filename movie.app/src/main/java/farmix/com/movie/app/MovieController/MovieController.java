package farmix.com.movie.app.MovieController;

import farmix.com.movie.app.Service.MovieService;
import farmix.com.movie.app.movies.Movie;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/movies/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), HttpStatus.OK);
    }
}
