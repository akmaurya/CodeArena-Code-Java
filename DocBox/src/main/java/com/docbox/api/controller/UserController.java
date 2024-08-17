package com.docbox.api.controller;

import com.docbox.api.customexception.ResourceNotFoundException;
import com.docbox.api.dto.AuthenticationResponse;
import com.docbox.api.dto.UserDTO;
import com.docbox.api.entity.Document;
import com.docbox.api.entity.DocumentImage;
import com.docbox.api.entity.User;
import com.docbox.api.service.CustomUserDetailsService;
import com.docbox.api.service.UserService;
import com.docbox.api.util.JwtUtil;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
    	
    		return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody User user) throws Exception {
    	try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id "+id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }
    
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.findByUsername(username);
            return ResponseEntity.ok(user);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with username: " + username);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }
    
    @PutMapping("/uploadProfilePhoto")
    public ResponseEntity<User> uploadImage(@RequestParam("userName") String userName,
            @RequestParam("file") MultipartFile profilePhoto) throws IOException {
    	userService.updateProfilePhoto(userName, profilePhoto);
    	User user = userService.findByUsername(userName);
        return ResponseEntity.ok(user);
    }
}