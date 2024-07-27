package com.docbox.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.docbox.api.entity.DocumentImage;

public interface DocumentImageRepository extends JpaRepository<DocumentImage, Long> {
    // custom queries if needed
	List<DocumentImage> findByDocumentId(Long documentId);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM DocumentImage di WHERE di.document.id = :documentId AND di.id NOT IN :excludedIds")
    void deleteByDocumentIdAndExcludedIds(Long documentId, List<Long> excludedIds);

	@Modifying
    @Transactional
    @Query("DELETE FROM DocumentImage di WHERE di.document.id = :docId")
	void deleteByDocumentId(Long docId);
}
