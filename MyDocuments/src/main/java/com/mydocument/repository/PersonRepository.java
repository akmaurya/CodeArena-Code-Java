package com.mydocument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydocument.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    // Add any additional methods for custom queries or operations
}