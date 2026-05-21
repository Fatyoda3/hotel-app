package com.hotel.app.models;

public class Hotel {
    private final String name;
    private final double totalRooms;
    public final String city;
    private final double hotelId;

    public Hotel(double hotelId,String name, double totalRooms, String city){
        this.hotelId = hotelId;
        this.name = name;
        this.totalRooms = totalRooms;
        this.city = city;
    }

}
