package com.littlestar.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlestar.api.entity.User;
import com.littlestar.api.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/details")
    public ResponseEntity<UserDetails> getUserDetails(Principal principal) {
        UserDetails user = userService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok(user);
    }
}
