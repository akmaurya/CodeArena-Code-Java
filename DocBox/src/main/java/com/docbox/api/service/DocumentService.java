package com.docbox.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docbox.api.customexception.ResourceNotFoundException;
import com.docbox.api.entity.Document;
import com.docbox.api.entity.DocumentImage;
import com.docbox.api.repository.DocumentImageRepository;
import com.docbox.api.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository documentRepository;

//    @Transactional
//    public Document saveDocument(Document document) {
//        if (document.getImages() != null) {
//            for (DocumentImage image : document.getImages()) {
//                image.setDocument(document);
//            }
//        }
//        return documentRepository.save(document);
//    }

	@Transactional
	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}

	@Autowired
	private DocumentImageRepository documentImageRepository;

	public Document saveDocument(String documentType, Long userId, Map<String, Object> fields, List<String> imageUrls,
			List<MultipartFile> files) throws IOException {
		Document document = new Document();
		document.setDocumentType(documentType);
		document.setUserId(userId);
		document.setFields(fields);

		List<DocumentImage> images = new ArrayList<>();
		if (imageUrls != null) {
			for (String url : imageUrls) {
				DocumentImage image = new DocumentImage();
				image.setImageUrl(url);
				image.setDocument(document);
				images.add(image);
			}
		}

		if (files != null) {
			for (MultipartFile file : files) {
				DocumentImage image = new DocumentImage();
				image.setName(file.getOriginalFilename());
				image.setData(file.getBytes());
				image.setDocument(document);
				images.add(image);
			}
		}

		document.setImages(images);
		return documentRepository.save(document);
	}

	@Transactional
	public Document getDocumentById(Long id) {
		return documentRepository.findById(id).orElse(null);
	}

	@Transactional
	public Document updateDocument(Long docId, String documentType, Long userId, Map<String, Object> fields,
			List<MultipartFile> files, String oldImageIds) throws IOException {
		Document existingDocument = documentRepository.findById(docId)
				.orElseThrow(() -> new ResourceNotFoundException("Document not found with id " + docId));

		if(oldImageIds.length()>0) {
		    List<Long> excludedList = Arrays.asList(oldImageIds.split(",")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
		    documentImageRepository.deleteByDocumentIdAndExcludedIds(docId, excludedList);
		}else {
			documentImageRepository.deleteByDocumentId(docId);
		}
		List<DocumentImage> images = new ArrayList<>();
		if (files != null) {
			for (MultipartFile file : files) {
				DocumentImage image = new DocumentImage();
				image.setName(file.getOriginalFilename());
				image.setData(file.getBytes());
				image.setDocument(existingDocument);
				images.add(image);
			}
			documentImageRepository.saveAll(images);
		}
		
		
		existingDocument.setDocumentType(documentType);
		existingDocument.setFields(fields);

//		documentRepository.save(existingDocument);

		// Update images
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
		return documentRepository.findByUserIdAndId(userId, documentId).orElseThrow(() -> new ResourceNotFoundException(
				"Document not found with id " + documentId + " for user " + userId));
	}

	public List<Document> findByUserId(Long userId) {
		return documentRepository.findByUserId(userId);
	}
}