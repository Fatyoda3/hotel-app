package com.hotel.app.repository;

import com.hotel.app.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Hotels extends MongoRepository<Hotel,Integer> {
    List<Hotel> getHotelsByCity(String city);
}
