package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.entity.MovieEntity;
import com.ticketbooking.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public MovieEntity addMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    public MovieEntity updateMovie(Long id, MovieEntity updatedMovie) {
        if (!movieRepository.existsById(id)) {
            return null; // Movie not found
        }
        updatedMovie.setId(id);
        return movieRepository.save(updatedMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

