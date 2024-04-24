package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.domain.Book;
import com.example.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book b) {
        return bookService.createBook(b);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/updateBook")
    public Book updateBook(@RequestParam Long id, @RequestBody Book b) {
        return bookService.updateBook(id, b);
    }

    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/getByNameLike")
    public List<Book> getByNameLike(@RequestParam String bookName) {
        return bookService.getByNameLike(bookName);
    }

    @GetMapping("/getByAuthor/{author}")
    public List<Book> getByAuthor(@PathVariable String author){
        return bookService.getByAuthor(author);
    }

}
