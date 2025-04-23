package com.irojas.demojwt.Repositories;

import com.irojas.demojwt.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfileRep extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.id = :idProfile")
    Optional<Profile> findByIdInteger(@Param("idProfile") Integer idProfile);

}
