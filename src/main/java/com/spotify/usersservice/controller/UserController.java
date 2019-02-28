package com.spotify.usersservice.controller;

import com.spotify.usersservice.dto.User;
import com.spotify.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping(path = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
