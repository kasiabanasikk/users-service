package com.spotify.usersservice.service;

public interface EncodingService {
    String encodePassword(String password);
    boolean checkPassword(String password, String hashedPass);
}
