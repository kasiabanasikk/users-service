package com.spotify.usersservice;

import com.spotify.usersservice.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  UserRepository extends MongoRepository<User, String> {

    User findByLogin(String login);
}
