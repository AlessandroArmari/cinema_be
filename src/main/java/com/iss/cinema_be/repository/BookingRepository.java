package com.iss.cinema_be.repository;

import com.iss.cinema_be.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
