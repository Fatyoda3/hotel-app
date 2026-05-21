package com.hotel.app.views;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public record BookingRequest(int hotelId, int rooms) {
    @Document
    public static record BookingRecord(@Id int bookingId, String userId, int hotelId, int totalRooms,double amount) {
    }
}
