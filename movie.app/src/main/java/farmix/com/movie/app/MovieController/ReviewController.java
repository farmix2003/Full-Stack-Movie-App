package farmix.com.movie.app.MovieController;

import farmix.com.movie.app.Service.ReviewService;
import farmix.com.movie.app.movies.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),
                payload.get("imdbId")), HttpStatus.CREATED);
    }
}
