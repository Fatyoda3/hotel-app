package service;

import com.hotel.app.models.Hotel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class HotelService {
    private final ArrayList<Hotel> hotels;
    private int id;

    public HotelService() {
        this.id = 0;
        this.hotels = new ArrayList<Hotel>();
    }

    @PostConstruct
    private  void addHotels(){
        Hotel hotel1 = new Hotel(this.NextId(), "Continental", 10, "New York");
        Hotel hotel2 = new Hotel(this.NextId(), "Tower", 5, "Chapra");
        Hotel hotel3 = new Hotel(this.NextId(), "Sackson", 3, "New York");
        this.hotels.add(hotel1);
        this.hotels.add(hotel2);
        this.hotels.add(hotel3);
    }

    private double NextId() {
        return  this.id++;
    }

    public Stream<Hotel> searchHotels(String city) {
        return this.hotels
                .stream()
                .filter(hotel -> hotel.city == city);
    }
}
