package com.iss.cinema_be.repository;

import com.iss.cinema_be.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DirectorRepository extends JpaRepository<Director, Long> {
}
