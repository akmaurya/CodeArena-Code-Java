package com.web.mydays.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.mydays.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
    /*List<User> findByName(String name);*/

}
