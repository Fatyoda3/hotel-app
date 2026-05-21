package com.hotel.app.controller;

import com.hotel.app.repository.Booking;
import com.hotel.app.repository.InMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Component
@RestController
//@RequestMapping("/api/bookings")
public class HotelBookingHandler {

    private final InMemory db;

    public HotelBookingHandler(InMemory db) {
        this.db = db;
    }


    @GetMapping("/api/bookings")
    public ResponseEntity<ArrayList<Booking>> getBookings() {

        ArrayList<Booking> bookings = db.getBookingsByUserId(1);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookings);
    }

    @GetMapping("/")
    public ResponseEntity<String> texty() {
        return ResponseEntity.ok().body("Hello wow");
    }


}
