package com.hotel.app.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class Users {
    private final HashMap<Integer, User> users = new HashMap<Integer, User>();

//    public User getUser(int userId) {
//        return users.get(userId);
//    }

    public int createUser(String username, String password) {
        int id = generateId();
        User user = new User(username, password);
        users.put(id, user);
        return id;
    }

    private Integer generateId() {
        return users.size() + 1;
    }

    public Integer getUserId(String username, String password) {

        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            Integer userId = entry.getKey();
            User user = entry.getValue();
            if (Objects.equals(user.username, username) && Objects.equals(user.password, password))
                return userId;
        }
        return -1;
    }
}
