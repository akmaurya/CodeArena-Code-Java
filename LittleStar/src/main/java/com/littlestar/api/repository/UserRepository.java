package com.littlestar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.littlestar.api.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
    User findByEmail(String email);
}
