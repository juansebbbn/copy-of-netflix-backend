package com.irojas.demojwt.Repositories;

import com.irojas.demojwt.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MovieRep extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.id = :idMovie")
    Optional<Movie> findByIdInteger(@Param("idMovie") Integer idMovie);
}
