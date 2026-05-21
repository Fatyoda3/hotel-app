package com.hotel.app.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemory {
    private final ArrayList<Booking> bookings = new ArrayList<>();

// bookingId hotelId userId roomCount(Booking)
    // UserId BookingIds (User)
    //

    public InMemory() {
        loadMockData();
    }

    private void loadMockData() {
        bookings.add(new Booking(1, 101, 1, 2));
        bookings.add(new Booking(2, 101, 2, 1));
        bookings.add(new Booking(3, 102, 1, 3));
        bookings.add(new Booking(4, 103, 3, 2));
        bookings.add(new Booking(5, 104, 4, 4));
        bookings.add(new Booking(6, 102, 5, 1));
        bookings.add(new Booking(7, 101, 6, 2));
        bookings.add(new Booking(8, 105, 1, 1));

    }
    public ArrayList<Booking> getBookingsByUserId(int userId) {
        System.out.println("HERE in userId");
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
