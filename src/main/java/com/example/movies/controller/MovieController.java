package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieRPS movieRPS;

    @GetMapping
    public List<Movie> getMovies(){
        return movieRPS.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id){
        return movieRPS.getMovie(id);
    }

    @PostMapping
    public String addMovie(@RequestBody Movie movie){
        movieRPS.addMovie(movie);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movieRPS.updateMovie(id, movie);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id){
        movieRPS.deleteMovie(id);
        return "Deleted";
    }
}
