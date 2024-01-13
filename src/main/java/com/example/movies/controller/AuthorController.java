package com.example.movies.controller;

import com.example.movies.model.Author;
import com.example.movies.repository.AuthorRPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRPS authorRPS;

    @GetMapping
    public List<Author> getAuthors(){
        return authorRPS.getAuthor();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id){
        return authorRPS.getAuthor(id);
    }

    @PostMapping
    public String addAuthor(@RequestBody Author author){
        authorRPS.addAuthor(author);
        return "Added Successfully";
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable int id, @RequestBody Author author){
        authorRPS.updateAuthor(id, author);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id){
        authorRPS.deleteAuthor(id);
        return "Deleted";
    }
}
