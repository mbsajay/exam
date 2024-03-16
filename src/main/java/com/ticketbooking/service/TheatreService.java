package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.entity.TheatreEntity;
import com.ticketbooking.repository.TheatreRepository;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public List<TheatreEntity> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public TheatreEntity getTheatreById(Long id) {
        return theatreRepository.findById(id).orElse(null);
    }

    public TheatreEntity addTheatre(TheatreEntity theatre) {
        return theatreRepository.save(theatre);
    }

    public TheatreEntity updateTheatre(Long id, TheatreEntity updatedTheatre) {
        if (!theatreRepository.existsById(id)) {
            return null; // Theatre not found
        }
        updatedTheatre.setId(id);
        return theatreRepository.save(updatedTheatre);
    }

    public void deleteTheatre(Long id) {
        theatreRepository.deleteById(id);
    }
}
