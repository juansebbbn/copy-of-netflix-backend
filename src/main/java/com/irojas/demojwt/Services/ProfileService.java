package com.irojas.demojwt.Services;

import com.irojas.demojwt.Models.Movie;
import com.irojas.demojwt.Models.Profile;
import com.irojas.demojwt.Repositories.MovieRep;
import com.irojas.demojwt.Repositories.ProfileRep;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRep repProfile;
    private final MovieRep repMovie;

    public ProfileService(ProfileRep repProfile, MovieRep repMovie) {
        this.repProfile = repProfile;
        this.repMovie = repMovie;
    }

    public List<Movie> getFavoritesMovies(Integer idProfile) {
        Profile profile = repProfile.findByIdInteger(idProfile)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        List<Integer> movieIds = profile.getFavoriteMovies();

        List<Movie> movies = movieIds.stream()
                .map(repMovie::findByIdInteger)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("Getting favorite movies for profile " + idProfile);
        return movies;
    }

    public List<Movie> getStartedMovies(Integer idProfile) {
        Profile profile = repProfile.findByIdInteger(idProfile)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        List<Integer> movieIds = profile.getStartedMovies();

        List<Movie> movies = movieIds.stream()
                .map(repMovie::findByIdInteger)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("Getting started movies for profile " + idProfile);
        return movies;
    }

    public boolean addFavoriteMovie(Integer idMovie, Integer idProfile) {
        Profile profile = repProfile.findByIdInteger(idProfile)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        if (!profile.getFavoriteMovies().contains(idMovie)) {
            profile.getFavoriteMovies().add(idMovie);
            repProfile.save(profile);
            return true;
        }
        return false;
    }

    public boolean addStartedMovie(Integer idMovie, Integer idProfile) {
        Profile profile = repProfile.findByIdInteger(idProfile)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        if (!profile.getStartedMovies().contains(idMovie)) {
            profile.getStartedMovies().add(idMovie);
            repProfile.save(profile);
            return true;
        }
        return false;
    }
}
