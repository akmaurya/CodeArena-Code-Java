package com.littlestar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.littlestar.api.dto.UserRegistrationDTO;
import com.littlestar.api.entity.User;
import com.littlestar.api.service.UserService;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
	@Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDto) {
        User user = userService.registerNewUser(registrationDto);
        return ResponseEntity.ok(user);
    }
}
