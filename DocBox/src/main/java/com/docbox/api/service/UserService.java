package com.docbox.api.service;

import com.docbox.api.customexception.ResourceNotFoundException;
import com.docbox.api.dto.UserDTO;
import com.docbox.api.entity.Document;
import com.docbox.api.entity.DocumentImage;
import com.docbox.api.entity.User;
import com.docbox.api.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
	public PasswordEncoder passwordEncoder;

    public UserDTO saveUser(User user) {
    	UserDTO userDTO = new UserDTO(user); 
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	if(findByUsername(user.getUsername())==null) {    		
    		user = userRepository.save(user);
    		userDTO = new UserDTO(user);
    		userDTO.setStatus(false);
    	}
        return userDTO;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    
    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        // Update fields
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword()); // Ensure password is handled securely (e.g., hashed)
        
        // Save updated user
        return userRepository.save(existingUser);
    }
    
    @Transactional
	public void updateProfilePhoto(String userName, MultipartFile profilePhoto) throws IOException {
		
    	User user = userRepository.findByUsername(userName);
    	user.setProfilePhoto(profilePhoto.getBytes());
    	userRepository.updateProfilePhoto(userName, profilePhoto.getBytes());
    	
//		return userRepository.updateProfilePhoto(userName, profilePhoto);
	}
}