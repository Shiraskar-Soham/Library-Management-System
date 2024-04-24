package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from Books where title like %?1%", nativeQuery = true)
    List<Book> findByTitleLike(String bookName);

    @Query(value = "Select * from Books where author like %?1% ", nativeQuery = true)
    List<Book> findByAuthor(String author);
}
