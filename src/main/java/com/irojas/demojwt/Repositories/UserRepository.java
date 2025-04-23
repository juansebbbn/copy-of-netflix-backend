package com.irojas.demojwt.Repositories;

import java.util.Optional;

import com.irojas.demojwt.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username); 
}
