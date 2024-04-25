package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.domain.Rental;
import com.example.libraryManagementSystem.repository.RentalRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental rentBook(Rental r) {
        if (ObjectUtils.isEmpty(r)) throw new RuntimeException("Rental cannot be empty");
        Rental old = rentalRepository.findByBookIdAndReturnDateIsNull(r.getBookId());
        if (!ObjectUtils.isEmpty(old)) throw new RuntimeException("Book already rented for bookId = " + r.getBookId());
        return rentalRepository.save(r);
    }

    public Rental returnBook(String bookId) {
        if (ObjectUtils.isEmpty(bookId)) throw new RuntimeException("Book Id cannot be empty");
        Rental r = rentalRepository.findByBookIdAndReturnDateIsNull(bookId);
        if (ObjectUtils.isEmpty(r)) throw new RuntimeException("Book not rented for bookId = " + bookId);
        Date currentDate = new Date(System.currentTimeMillis());
        r.setReturnDate(currentDate);
        return rentalRepository.save(r);
    }

    public List<Rental> getAllRentalsByBookId(String bookId) {
        if (ObjectUtils.isEmpty(bookId)) throw new RuntimeException("Book Id cannot be empty");
        return rentalRepository.findByBookId(bookId);
    }
}
