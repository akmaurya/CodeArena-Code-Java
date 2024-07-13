package com.littlestar.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.littlestar.api.dto.UserRegistrationDTO;
import com.littlestar.api.entity.User;
import com.littlestar.api.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationDTO registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());

        return userRepository.save(user);
    }
}
