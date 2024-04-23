package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
