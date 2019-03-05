package com.spotify.usersservice.service.impl;

import com.spotify.usersservice.service.EncodingService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EncodingServiceImpl implements EncodingService {

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean checkPassword(String password, String hashedPass){
        return bCryptPasswordEncoder.matches(password, hashedPass);
    }
}
