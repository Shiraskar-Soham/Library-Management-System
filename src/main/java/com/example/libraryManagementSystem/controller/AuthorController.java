package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.domain.Author;
import com.example.libraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/add")
    public Author addAuthor (@RequestBody Author a){return authorService.createAuthor(a);}

    @GetMapping("/getAll")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("/updateAuthor")
    public Author updateAuthor(@RequestParam Long id, @RequestBody Author a){
        return authorService.updateAuthor(id, a);
    }

    @DeleteMapping("/deleteAuthor")
    public void deleteAuthor(@RequestParam Long id){
        authorService.deleteAuthor(id);
    }

}
