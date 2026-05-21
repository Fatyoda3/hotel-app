package com.hotel.app.repository;

import java.util.ArrayList;
import java.util.List;

public class InMemory {
    private final ArrayList<Booking> bookings = new ArrayList<>();

// bookingId hotelId userId roomCount(Booking)
    // UserId BookingIds (User)
    //

    public ArrayList<Booking> getBookingsByUserId(int userId) {
        ArrayList<Booking> list = new ArrayList<>();
        for (Booking booking : this.bookings) {
            if (booking.userId() == userId) {
                list.add(booking);
            }
        }

        return list;

    }

    public boolean createBooking(int userId, int hotelId, int roomCount) {
        int bookingId = this.generateId();
        Booking booking = new Booking(bookingId, userId, hotelId, roomCount);
        return this.bookings.add(booking);
    }

    private int generateId() {
        return this.bookings.size() + 1;
    }
}
