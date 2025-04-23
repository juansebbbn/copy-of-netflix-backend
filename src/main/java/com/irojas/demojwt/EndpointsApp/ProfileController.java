package com.irojas.demojwt.EndpointsApp;

import com.irojas.demojwt.Models.Movie;
import com.irojas.demojwt.Services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/started/{idProfile}") //this endpoint is working good
    public ResponseEntity<List<Movie>> getStarted(@PathVariable Integer idProfile) {
        List<Movie> startedMovies = profileService.getStartedMovies(idProfile);

        return ResponseEntity.ok(startedMovies);
    }

    @GetMapping("/favorites/{idProfile}") //this endpoint is working good
    public ResponseEntity<List<Movie>> getFavorites(@PathVariable Integer idProfile) {
        List<Movie> startedMovies = profileService.getFavoritesMovies(idProfile);

        return ResponseEntity.ok(startedMovies);
    }

    @PostMapping("/addFavorite/{idProfile}/{idMovie}") //this endpoint is working good
    public ResponseEntity<Boolean> addFavoriteMovie(
            @PathVariable Integer idProfile,
            @PathVariable Integer idMovie) {

        boolean isAdded = profileService.addFavoriteMovie(idMovie, idProfile);

        return ResponseEntity.ok(isAdded);
    }

    @PostMapping("/addStarted/{idProfile}/{idMovie}") //this endpoint is working good
    public ResponseEntity<Boolean> addStartedMovie(
            @PathVariable Integer idProfile,
            @PathVariable Integer idMovie) {

        boolean isAdded = profileService.addStartedMovie(idMovie, idProfile);

        return ResponseEntity.ok(isAdded);
    }

}
