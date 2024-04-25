package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.domain.Rental;
import com.example.libraryManagementSystem.service.RentalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rentBook")
    public Rental rentBook(Rental r) {
        return rentalService.rentBook(r);
    }

    @PostMapping("/returnBook")
    public Rental returnBook(String bookId) {
        return rentalService.returnBook(bookId);
    }

    @GetMapping("/getAllRentalsByBookId")
    public List<Rental> getAllRentalsByBookId(String bookId) {
        return rentalService.getAllRentalsByBookId(bookId);
    }
}
