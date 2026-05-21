package com.hotel.app.controller;

import com.hotel.app.models.Booking;
import com.hotel.app.repository.BookingRepository;
import com.hotel.app.repository.InMemory;
import com.hotel.app.service.BookingService;
import com.hotel.app.views.BookingRequest;
import org.osgi.resource.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
public class HotelBookingHandler {
    private final BookingService bookingService;

    public HotelBookingHandler( BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/api/bookings")
    public ResponseEntity<List<BookingRequest>> getBookings() {

        List<BookingRequest> bookings = bookingService.getBookingsByUSerId("1");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookings);
    }
}

