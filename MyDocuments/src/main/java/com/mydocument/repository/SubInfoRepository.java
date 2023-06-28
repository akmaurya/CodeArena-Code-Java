package com.mydocument.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydocument.model.SubInfo;

@Repository
public interface SubInfoRepository extends JpaRepository<SubInfo, Long> {
    // Add any additional methods for custom queries or operations
}