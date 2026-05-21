package com.hotel.app;

import com.hotel.app.repository.Booking;
import com.hotel.app.repository.InMemory;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class inMemoryTest {
    @Test
    void shouldReturnNoBookings() {
        InMemory inMemory = new InMemory();
        ArrayList<Booking> bookings = inMemory.getBookingsByUserId(1);
        assertEquals(0, bookings.size());

    }


    @Test
    void shouldReturnBooking() {
        InMemory inMemory = new InMemory();
        inMemory.createBooking(1, 1, 1);
        ArrayList<Booking> bookings = inMemory.getBookingsByUserId(1);

        ArrayList<Booking> expected = new ArrayList<>();
        Booking booking = new Booking(1, 1, 1, 1);
        expected.add(booking);
        assertEquals(bookings, expected);
    }
}
