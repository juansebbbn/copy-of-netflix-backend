package com.irojas.demojwt.EndpointsApp;

import com.irojas.demojwt.Models.Movie;
import com.irojas.demojwt.Models.MoviePremiere;
import com.irojas.demojwt.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")  //tested and working, movies are added succesfully
    public ResponseEntity<Boolean> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PostMapping("/addPremiere") //tested and working, premiere movies are added succesfully
    public ResponseEntity<Boolean> addPremiere(@RequestBody MoviePremiere movie) {
        return ResponseEntity.ok(movieService.addPremiere(movie));
    }

    @GetMapping("/getPremiere")
    public ResponseEntity<List<MoviePremiere>> getPremiere() {
        return ResponseEntity.ok(movieService.getPremiere());
    }

    @DeleteMapping("/deleteMovie/{movieId}") //tested and working, movies are deleted succesfully
    public ResponseEntity<Boolean> deleteMovie(@PathVariable Integer movieId) {
        return ResponseEntity.ok(movieService.deleteMovie(movieId));
    }

    @GetMapping("/getMovie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/getMovies") //tested and working
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

}
