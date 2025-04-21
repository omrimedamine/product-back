package com.example.productback.service;

import com.example.productback.payload.request.SignupRequest;

public interface UserService {
    void createUser(SignupRequest signUpRequest);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
