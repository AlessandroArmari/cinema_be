package com.iss.cinema_be.repository;

import com.iss.cinema_be.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DirectorRepository extends JpaRepository<Director, Long> {

    Optional<Director> findByUuid(UUID uuid);


}
