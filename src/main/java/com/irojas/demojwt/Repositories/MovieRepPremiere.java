package com.irojas.demojwt.Repositories;

import com.irojas.demojwt.Models.MoviePremiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepPremiere extends JpaRepository<MoviePremiere, Integer> {

}
