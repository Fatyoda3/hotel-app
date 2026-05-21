package com.hotel.app.service;

import com.hotel.app.models.Hotel;
import com.hotel.app.repository.Hotels;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class HotelService {
    private final ArrayList<Hotel> hotels;
    private final Hotels hotelRepo;
    private int id;

    public HotelService(Hotels hotels) {
        this.hotelRepo = hotels;
        this.id = 0;
        this.hotels = new ArrayList<Hotel>();
    }

    @PostConstruct
    private  void addHotels(){
        Hotel hotel1 = new Hotel(this.NextId(), "Continental", 10, "New York");
        Hotel hotel2 = new Hotel(this.NextId(), "Tower", 5, "Chapra");
        Hotel hotel3 = new Hotel(this.NextId(), "Sackson", 3, "New York");
        hotelRepo.save(hotel1);
        hotelRepo.save(hotel2);
        hotelRepo.save(hotel3);
    }

    private double NextId() {
        return  ++this.id;
    }

    public List<Hotel> searchHotels(String city) {
        return hotelRepo.getHotelsByCity(city);
    }
}
