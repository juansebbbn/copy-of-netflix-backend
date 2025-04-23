package com.irojas.demojwt.Services;

import com.irojas.demojwt.Models.Movie;
import com.irojas.demojwt.Models.MoviePremiere;
import com.irojas.demojwt.Repositories.MovieRep;
import com.irojas.demojwt.Repositories.MovieRepPremiere;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRep movieRep;
    private final MovieRepPremiere movieRepPremiere;

    public MovieService(MovieRep movieRep, MovieRepPremiere movieRepPremiere) {
        this.movieRep = movieRep;
        this.movieRepPremiere = movieRepPremiere;
    }

    public Boolean addMovie(Movie movie) {
        movieRep.save(movie);
        return true;
    }

    public Boolean addPremiere(MoviePremiere movie) {

        // if I add a new premiere movie, the last one will automatically be deleted.

        if(movieRepPremiere.count() > 0){
            movieRepPremiere.deleteAll();
        }

        System.out.println("premiere added");

        movieRepPremiere.save(movie);
        return true;
    }

    public Boolean deleteMovie(Integer movieId) {
        Optional<Movie> movie = movieRep.findById(movieId);

        if(movie.isPresent()) {
            movieRep.deleteById(movieId);
            return true;
        }

        System.out.println("movie not found");
        return false;
    }

    public List<Movie> getAllMovies() {
        return movieRep.findAll();
    }


    public List<MoviePremiere> getPremiere() {
        return movieRepPremiere.findAll();
    }

    public Movie getMovieById(Integer id) {
        Optional<Movie> movie = movieRep.findById(id);

        if(movie.isPresent()) {
            return movie.get();
        }

        System.out.println("movie not found");
        return null;
    }
}
