package com.iss.cinema_be.repository;

import com.iss.cinema_be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
