package com.littlestar.api.controller;


import com.littlestar.api.dto.LoginRequestDTO;
import com.littlestar.api.dto.LoginResponseDTO;
import com.littlestar.api.service.CustomUserDetailsService;
import com.littlestar.api.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LoginController {

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                		loginRequestDTO.getEmail(),
//                		loginRequestDTO.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getEmail());
//        
//        LoginResponseDTO response = new LoginResponseDTO(userDetails.getUsername(), "User authenticated successfully");
//        
//        return ResponseEntity.ok(response);
//    }
	
	
//	@Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                		loginRequestDTO.getEmail(),
//                		loginRequestDTO.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getEmail());
//        String token = jwtUtil.generateToken(userDetails);
//
//        LoginResponseDTO response = new LoginResponseDTO(userDetails.getUsername(), "User authenticated successfully", token);
//
//        return ResponseEntity.ok(response);
//    }
}