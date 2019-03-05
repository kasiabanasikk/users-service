package com.spotify.usersservice.controller;

import com.spotify.usersservice.dto.User;
import com.spotify.usersservice.service.EncodingService;
import com.spotify.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userService;
    EncodingService encodingService;

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping(path = "/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping(path = "/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @PostMapping(path = "/authentication")
    public String checkUser(@RequestBody User user){
        User userFromDb = userService.getUserByLogin(user.getLogin());
        if(null != userFromDb && encodingService.checkPassword(user.getPassword(), userFromDb.getPassword())){
            return "Login and password correct";
        }
        return "Login or password incorrect";
    }

    @DeleteMapping(path = "/users/{id}")
    public User updateUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
