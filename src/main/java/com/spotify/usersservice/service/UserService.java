package com.spotify.usersservice.service;

import com.spotify.usersservice.dao.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    User getUserByLogin(String login);
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
}
