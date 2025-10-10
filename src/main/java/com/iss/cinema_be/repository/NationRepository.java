package com.iss.cinema_be.repository;

import com.iss.cinema_be.entity.Movie;
import com.iss.cinema_be.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nation, String> {

    Nation findByNationCode(String nationCode);
}
