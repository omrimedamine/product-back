package com.example.productback.service;

import com.example.productback.payload.request.SignupRequest;
import com.example.productback.model.User;
import com.example.productback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void createUser(SignupRequest signUpRequest) {
        // Create new user's account
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setFirstname(signUpRequest.getFirstname());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
