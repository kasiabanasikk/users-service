package com.spotify.usersservice.service;

import com.spotify.usersservice.dto.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    List<User> getAllUsers();
    void addUser(User user);
}
