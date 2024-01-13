package com.example.movies.controller;

import com.example.movies.model.Genre;
import com.example.movies.repository.GenreRPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreRPS genreRPS;

    @GetMapping
    public List<Genre> getGenres(){
        return genreRPS.getGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable int id){
        return genreRPS.getGenre(id);
    }

    @PostMapping
    public String addGenre(@RequestBody Genre genre){
        genreRPS.addGenre(genre);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateGenre(@PathVariable int id, @RequestBody Genre genre){
        genreRPS.updateGenre(id, genre);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable int id){
        genreRPS.deleteGenre(id);
        return "Deleted";
    }
}
