package com.example.movies.repository;

import com.example.movies.model.Author;
import com.example.movies.repository.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRPS {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> getAuthor(){
        return jdbcTemplate.query(
                "select * from authors",
                new AuthorMapper()
        );
    }

    public Author getAuthor(int id){
        return jdbcTemplate.queryForObject(
                "select * from authors where id = ?",
                new Object[]{id},
                new AuthorMapper()
        );
    }

    public boolean addAuthor(Author author){
        jdbcTemplate.update(
                "insert into authors(name) values (?)",
                author.getName()
        );
        return true;
    }

    public boolean updateAuthor(int id, Author author){
        jdbcTemplate.update(
                "update authors set name = ? where id = ?",
                author.getName(),
                id
        );
        return true;
    }

    public boolean deleteAuthor(int id){
        jdbcTemplate.update(
                "delete from authors where id = ?",
                id
        );
        return true;
    }
}
