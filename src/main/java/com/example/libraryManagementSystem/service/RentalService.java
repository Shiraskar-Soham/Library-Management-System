package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.domain.Rental;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RentalService {
    public Rental rentBook(Rental r) {
        if (ObjectUtils.isEmpty(r)) throw new RuntimeException("Rental cannot be empty");
        return null;
    }

    public Rental returnBook(String bookId) {
        if (ObjectUtils.isEmpty(bookId)) throw new RuntimeException("Book Id cannot be empty");
        return null;
    }
}
