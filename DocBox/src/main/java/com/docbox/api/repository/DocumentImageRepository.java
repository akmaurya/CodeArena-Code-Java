package com.docbox.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docbox.api.entity.DocumentImage;

public interface DocumentImageRepository extends JpaRepository<DocumentImage, Long> {
    // custom queries if needed
}
