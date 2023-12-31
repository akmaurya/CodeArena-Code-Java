package com.mydocument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydocument.model.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {
    // Add any additional methods for custom queries or operations
}