package com.hotel.app;

import com.hotel.app.repository.InMemory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HotelApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HotelApp.class);
        ConfigurableApplicationContext ctx = app.run(args);

        InMemory db = ctx.getBean(InMemory.class);
    }

}
