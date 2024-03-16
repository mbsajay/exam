package com.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.entity.BookingEntity;
import com.ticketbooking.repository.BookingRepository;
import com.ticketbooking.repository.MovieRepository;
import com.ticketbooking.repository.TheatreRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<BookingEntity> getBookingsByUserId(Long userId) {
        // Implement logic to fetch bookings by user ID
        return null;
    }

    public boolean bookSeat(Long movieId, Long theatreId, LocalDateTime showTime, int seatNumber) {
        // Check if the theatre, movie, and show exist
        if (!theatreRepository.existsById(theatreId) || !movieRepository.existsById(movieId)) {
            return false; // Theatre or movie not found
        }

        // Implement logic to check if seat is available for the given show time

        // Proceed with booking
        BookingEntity booking = new BookingEntity();
        booking.setMovie(movieRepository.findById(movieId).orElse(null));
        booking.setTheatre(theatreRepository.findById(theatreId).orElse(null));
        booking.setShowTime(showTime);
        booking.setSeatNumber(seatNumber);
        bookingRepository.save(booking);
        return true;
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
