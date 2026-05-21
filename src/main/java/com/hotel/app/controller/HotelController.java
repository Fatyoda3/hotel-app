package com.hotel.app.controller;

import com.hotel.app.exceptions.InvalidRequestException;
import com.hotel.app.views.Hotel;
import com.hotel.app.views.BookingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hotel.app.service.HotelService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")

public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/search/hotels")
    public List<Hotel> searchHotels(@RequestParam String city) {
        return hotelService.searchHotels(city);
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> BookHotel(@RequestBody BookingRequest bookingRequest) throws InvalidRequestException {
        try {
            hotelService.book(bookingRequest);
            return ResponseEntity.ok("message:booking successful");
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
