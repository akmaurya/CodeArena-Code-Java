package com.docbox.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docbox.api.entity.DocumentImage;
import com.docbox.api.repository.DocumentImageRepository;

@Service
public class DocumentImageService {
	@Autowired
    private DocumentImageRepository documentImageRepository;

	@Transactional
    public DocumentImage saveDocumentImage(DocumentImage documentImage) {
        return documentImageRepository.save(documentImage);
    }

	@Transactional
    public List<DocumentImage> getDocumentImagesByDocumentId(Long documentId) {
        return documentImageRepository.findByDocumentId(documentId);
    }

	@Transactional
    public void deleteDocumentImage(Long id) {
        documentImageRepository.deleteById(id);
    }

}