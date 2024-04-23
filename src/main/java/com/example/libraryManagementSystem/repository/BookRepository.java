package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
