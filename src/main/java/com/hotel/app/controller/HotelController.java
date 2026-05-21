package com.hotel.app.controller;

import com.hotel.app.models.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

}
