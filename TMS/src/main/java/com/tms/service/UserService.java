package com.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tms.model.User;
import com.tms.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	public final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public boolean isUserExists(String email, String password) {
		List<User> list = userRepository.findByEmailAndPassword(email,password);
		if(!list.isEmpty()) {
			return true; 
		} else {
			return false;
		}
	}	
}
