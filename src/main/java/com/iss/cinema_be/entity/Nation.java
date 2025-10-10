package com.iss.cinema_be.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nation {

    @Id
    private String nationCode;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "nationalities")
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "nationalities")
    private Set<Director> directors;
}
