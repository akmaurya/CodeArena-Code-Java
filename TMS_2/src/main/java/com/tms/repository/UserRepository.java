package com.tms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tms.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	List<User> findByEmailAndPassword(String email, String password);
}
