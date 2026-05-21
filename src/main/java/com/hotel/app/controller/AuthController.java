package com.hotel.app.controller;

import com.hotel.app.repository.User;
import com.hotel.app.repository.Users;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    Users users;
    @PostMapping("/api/users/register")
    public String signup(@RequestBody Credentials credentials) {

        int userId = users.createUser(credentials.username(), credentials.password());
        System.out.println(userId + " -- Created ");
        User user = users.getUser(1);
        System.out.println(user);
        return "created";
    }
}
