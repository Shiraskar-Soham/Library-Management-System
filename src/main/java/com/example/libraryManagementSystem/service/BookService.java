package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.domain.Book;
import com.example.libraryManagementSystem.repository.BookRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book b) {
        if (ObjectUtils.isEmpty(b)) return null;
        if (!isValidISBN(b.getIsbn())){
            throw new RuntimeException("ISBN not valid");
        }
        bookRepository.save(b);
        return b;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book b) {
        if (id == null || ObjectUtils.isEmpty(b)) return null;
        Optional<Book> old = bookRepository.findById(id);
        if (ObjectUtils.isEmpty(old)) throw new RuntimeException("Book Not Found for id = " + id);
        b.setId(id);
        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book Not Found for id = " + id);
        }
    }

    public List<Book> getByNameLike(String bookName) {
        if (ObjectUtils.isEmpty(bookName)) throw new RuntimeException("Book Name Cant be empty");
        List<Book> books = bookRepository.findByTitleLike(bookName);
        if (ObjectUtils.isEmpty(books)) throw new RuntimeException("Book Not Found");
        return books;
    }

    public List<Book> getByAuthor(String author) {
        if (ObjectUtils.isEmpty(author)) throw new RuntimeException("Author name cannot be empty");
        List<Book> books = bookRepository.findByAuthor(author);
        if (ObjectUtils.isEmpty(books)) throw new RuntimeException("No book found");
        return books;
    }

    public List<Book> getBooksByIds(Set<Long> bookIds) {
        if (ObjectUtils.isEmpty(bookIds)) throw new RuntimeException("Book Ids cannot be empty");
        List<Book> books = bookRepository.findByIdIn(bookIds);
        if (ObjectUtils.isEmpty(books)) throw new RuntimeException("No book found");
        return books;
    }

    public List<Book> getAvailableBooks(Set<Long> rentedBookIds) {
        return bookRepository.findByIdNotIn(rentedBookIds);
    }

    public boolean existsById(Long bookId) {
        return bookRepository.existsById(bookId);
    }

    private static boolean isValidISBN(String isbn) {
        String isbnPattern = "^\\d{10}$|^\\d{13}$";
        Pattern pattern = Pattern.compile(isbnPattern);
        Matcher matcher = pattern.matcher(isbn);
        return matcher.matches();
    }

}