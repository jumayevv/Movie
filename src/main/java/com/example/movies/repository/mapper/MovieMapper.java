package com.example.movies.repository.mapper;

import com.example.movies.model.Author;
import com.example.movies.model.Genre;
import com.example.movies.model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                new Genre(
                        rs.getInt(4),
                        rs.getString(5)
                ),
                new Author(
                        rs.getInt(6),
                        rs.getString(7)
                )
        );
    }
}
