package com.spotify.usersservice.service;

import com.spotify.usersservice.dto.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    User getUserByLogin(String login);
    List<User> getAllUsers();
    void addUser(User user);
    String encodePassword(String password);
    boolean checkPassword(String password, String hashedPass);
}
