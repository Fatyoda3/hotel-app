package com.hotel.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {
    @Id
    public final double hotelId;
    public final String name;
    public final double totalRooms;
    public final String city;

    public Hotel(double hotelId,String name, double totalRooms, String city){
        this.hotelId = hotelId;
        this.name = name;
        this.totalRooms = totalRooms;
        this.city = city;
    }

}
