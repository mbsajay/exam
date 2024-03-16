package com.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.entity.TheatreEntity;
import com.ticketbooking.service.TheatreService;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public ResponseEntity<List<TheatreEntity>> getAllTheatres() {
        List<TheatreEntity> theatres = theatreService.getAllTheatres();
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreEntity> getTheatreById(@PathVariable Long id) {
        TheatreEntity theatre = theatreService.getTheatreById(id);
        if (theatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TheatreEntity> addTheatre(@RequestBody TheatreEntity theatre) {
        TheatreEntity addedTheatre = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(addedTheatre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TheatreEntity> updateTheatre(@PathVariable Long id, @RequestBody TheatreEntity updatedTheatre) {
        TheatreEntity theatre = theatreService.updateTheatre(id, updatedTheatre);
        if (theatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
