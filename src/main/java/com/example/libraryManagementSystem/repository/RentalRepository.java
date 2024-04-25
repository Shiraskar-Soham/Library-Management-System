package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query(value = "select * from Rentals where returnDate is null and bookId = ?1", nativeQuery = true)
    Rental findByBookIdAndReturnDateIsNull(String bookId);
}
