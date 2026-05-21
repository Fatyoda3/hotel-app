package com.hotel.app.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
@Repository
public class Users {
    private final HashMap<Integer, User> users = new HashMap<Integer, User>();

    public User getUser(int userId) {
        return users.get(userId);
    }

    public int createUser(String username, String password) {
        int id = generateId();
        users.put(id, new User(username, password));
        return id;
    }

    private Integer generateId() {
        return users.size() + 1;
    }

}
