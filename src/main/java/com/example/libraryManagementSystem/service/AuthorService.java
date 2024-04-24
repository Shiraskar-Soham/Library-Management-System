package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.domain.Author;
import com.example.libraryManagementSystem.domain.Book;
import com.example.libraryManagementSystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public Author createAuthor(Author a) {

        if (ObjectUtils.isEmpty(a)) return null;
        authorRepository.save(a);
        return a;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public Author updateAuthor(Long id, Author a) {
        if (id == null || ObjectUtils.isEmpty(a)) return null;
        Optional<Author> old = authorRepository.findById(id);
        if (ObjectUtils.isEmpty(old)) throw new RuntimeException("Author Not Found for id = " + id);
        a.setId(id);
        return authorRepository.save(a);
    }

    public void deleteAuthor(Long id) {
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }
        else throw new RuntimeException("Author Not Found for id = " + id);
    }
}
