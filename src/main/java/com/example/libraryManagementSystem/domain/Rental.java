package com.example.libraryManagementSystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId; // This field represents the foreign key to the Book entity's id

    @Column(nullable = false)
    private String renterName;

    @Column(nullable = false)
    private Date rentalDate;

    private Date returnDate;
}
