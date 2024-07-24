package com.docbox.api.service;

import com.docbox.api.customexception.ResourceNotFoundException;
import com.docbox.api.entity.Document;
import com.docbox.api.entity.DocumentImage;
import com.docbox.api.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;

@Service
public class DocumentService {
	@Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public Document saveDocument(Document document) {
        if (document.getImages() != null) {
            for (DocumentImage image : document.getImages()) {
                image.setDocument(document);
            }
        }
        return documentRepository.save(document);
    }

    @Transactional
    public Document updateDocument(Long id, Document document) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + id));

        existingDocument.setUserId(document.getUserId());
        existingDocument.setDocumentType(document.getDocumentType());
        existingDocument.setFields(document.getFields());

        // Update images
        existingDocument.getImages().clear();
        if (document.getImages() != null) {
            for (DocumentImage image : document.getImages()) {
                image.setDocument(existingDocument);
                existingDocument.getImages().add(image);
            }
        }

        return documentRepository.save(existingDocument);
    }
    
    @Transactional
    public void deleteDocument(Long id) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + id));
        documentRepository.delete(existingDocument);
    }
    
    
    @Transactional
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Transactional
    public List<Document> getDocumentsByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }
    
    @Transactional
    public Document getDocumentByUserIdAndDocumentId(Long userId, Long documentId) {
        return documentRepository.findByUserIdAndId(userId, documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + documentId + " for user " + userId));
    }
    
    public List<Document> findByUserId(Long userId) {
        return documentRepository.findByUserId(userId);
    }
}