package com.example.libraryManagementSystem.repository;

import com.example.libraryManagementSystem.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
