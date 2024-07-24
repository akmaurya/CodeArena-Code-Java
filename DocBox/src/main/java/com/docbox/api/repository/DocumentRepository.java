package com.docbox.api.repository;

import com.docbox.api.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
 
	List<Document> findByUserId(Long userId);
	Optional<Document> findByUserIdAndId(Long userId, Long id);
}
