package com.hotel.app.service;

import com.hotel.app.repository.BookingRepository;
import com.hotel.app.views.BookingRecord;
import com.hotel.app.views.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private int bookingId;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingId = 0;
    }

    public BookingRecord book(BookingRequest bookingRequest, double price) {
        BookingRecord bookingRecord = new BookingRecord(this.nextId(),
                "123",
                bookingRequest.hotelId(),
                bookingRequest.rooms(),
                bookingRequest.rooms() * price
        );

        this.bookingRepository.save(bookingRecord);
        return bookingRecord;
    }

    private int nextId() {
        return ++this.bookingId;
    }

}
