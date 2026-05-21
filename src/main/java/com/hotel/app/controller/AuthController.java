package com.hotel.app.controller;

import com.hotel.app.repository.User;
import com.hotel.app.repository.Users;

import com.hotel.app.utils.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final Users users;

    public AuthController(Users users) {
        this.users = users;
    }

    @PostMapping("/api/users/register")
    public String signup(@RequestBody Credentials credentials) {
        int userId = users.createUser(credentials.username(), credentials.password());
        String token = JwtUtil.generateToken(userId);
        return token;
    }

    @PostMapping("/api/users/login")
    public String login(@RequestBody Credentials credentials) {

        Integer userId = users.getUserId(credentials.username() , credentials.password());
        if(userId == -1) {
            return "Invalid Credentials";
        }

        String token = JwtUtil.generateToken(userId);
        return token;
    }

}
