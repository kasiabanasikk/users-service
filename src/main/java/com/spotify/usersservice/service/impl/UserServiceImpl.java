package com.spotify.usersservice.service.impl;

import com.spotify.usersservice.UserRepository;
import com.spotify.usersservice.dao.User;
import com.spotify.usersservice.service.EncodingService;
import com.spotify.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    EncodingService encodingService;

    @Override
    public User getUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        user.setPassword(encodingService.encodePassword(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(String id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        User userFromDb = null;
        if(userOptional.isPresent()){
            userFromDb = userOptional.get();
            userFromDb.setLogin(user.getLogin());
            userFromDb.setPassword(encodingService.encodePassword(user.getPassword()));
            userRepository.save(userFromDb);
        }
        return userFromDb;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


}
