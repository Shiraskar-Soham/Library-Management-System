package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.domain.Book;
import com.example.libraryManagementSystem.domain.Rental;
import com.example.libraryManagementSystem.repository.RentalRepository;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookService bookService;

    private final int OVERDUE_DAYS = 14;

    public Rental rentBook(Rental r) {
        if (ObjectUtils.isEmpty(r)) throw new RuntimeException("Rental cannot be empty");
        Rental old = rentalRepository.findByBookIdAndReturnDateIsNull(r.getBookId());
        if (!ObjectUtils.isEmpty(old)) throw new RuntimeException("Book already rented for bookId = " + r.getBookId());
        return rentalRepository.save(r);
    }

    public Rental returnBook(Long bookId) {
        if (ObjectUtils.isEmpty(bookId)) throw new RuntimeException("Book Id cannot be empty");
        Rental r = rentalRepository.findByBookIdAndReturnDateIsNull(bookId);
        if (ObjectUtils.isEmpty(r)) throw new RuntimeException("Book not rented for bookId = " + bookId);
        Date currentDate = new Date(System.currentTimeMillis());
        r.setReturnDate(currentDate);
        return rentalRepository.save(r);
    }

    public List<Rental> getAllRentalsByBookId(Long bookId) {
        if (ObjectUtils.isEmpty(bookId)) throw new RuntimeException("Book Id cannot be empty");
        return rentalRepository.findByBookId(bookId);
    }

    public List<Book> getAllBooksRented() {
        Set<Long> bookIds = rentalRepository.findBookIdsByReturnDateIsNull();
        if (ObjectUtils.isEmpty(bookIds)) return null;
        return bookService.getBooksByIds(bookIds);
    }

    public List<Book> getAvailableBooks() {
        Set<Long> rentedBookIds = rentalRepository.findBookIdsByReturnDateIsNull();
        if (ObjectUtils.isEmpty(rentedBookIds)) return bookService.getAllBooks();
        return bookService.getAvailableBooks(rentedBookIds);
    }

    public List<Pair<Rental, Book>> getOverdueRentals() {
        Date rentedSafeDate = new Date(System.currentTimeMillis()-(OVERDUE_DAYS*24*60*60*1000));
        Set<Long> overdueBookIds = rentalRepository.findBookIdsByRentalDateLessThanAndReturnDateIsNull(rentedSafeDate);
        return bookService.getBooksByIds(overdueBookIds).stream().map(b -> Pair.of(rentalRepository.findByBookIdAndReturnDateIsNull(b.getId()), b)).toList();
    }
}
