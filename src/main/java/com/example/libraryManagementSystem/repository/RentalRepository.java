package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Rental;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query(value = "select * from Rentals where returnDate is null and bookId = ?1", nativeQuery = true)
    Rental findByBookIdAndReturnDateIsNull(Long bookId);

    List<Rental> findByBookId(Long bookId);

    @Query(value = "select distinct bookId from Rentals where returnDate is null", nativeQuery = true)
    Set<Long> findBookIdsByReturnDateIsNull();

    @Query(value = "select distinct bookId from Rentals where rentalDate < ?1 and returnDate is null", nativeQuery = true)
    Set<Long> findBookIdsByRentalDateLessThanAndReturnDateIsNull(Date rentedSafeDate);
}
