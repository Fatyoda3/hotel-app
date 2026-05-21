package com.hotel.app.service;

import com.hotel.app.repository.BookingRepository;
import com.hotel.app.views.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookingService {

    private final HashMap<String, BookingRequest.BookingRecord> bookingDetails;
    private final BookingRepository bookingRepository;
    private int bookingId;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingDetails = new HashMap<String, BookingRequest.BookingRecord>();
        this.bookingId = 0;
    }

    public BookingRequest.BookingRecord book(BookingRequest bookingRequest) {
        BookingRequest.BookingRecord bookingRecord = new BookingRequest.BookingRecord(this.nextId(),
                "123",
                bookingRequest.hotelId(),
                bookingRequest.rooms());

        this.bookingRepository.save(bookingRecord);
        return bookingRecord;
    }

    public List<BookingRequest> getBookingsByUSerId(String userId) {
        return bookingRepository.getBookingsByUserId(userId);
    }

    private int nextId() {
        return ++this.bookingId;
    }

    public String buildPdf(List<BookingRequest> bookings) {
        bookings.forEach(booking -> {


        });
        return "";
    }
}
