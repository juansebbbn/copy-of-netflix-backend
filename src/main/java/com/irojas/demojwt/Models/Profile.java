package com.irojas.demojwt.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "user")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_profile;
    private String profileName;
    private String profileImage;
    private String profileDescription;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private User user;

    @ElementCollection
    private List<Integer> favoriteMovies;
    @ElementCollection
    private List<Integer> startedMovies;
}
