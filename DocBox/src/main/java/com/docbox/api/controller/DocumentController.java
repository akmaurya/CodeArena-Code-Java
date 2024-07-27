package com.docbox.api.controller;

import com.docbox.api.customexception.ResourceNotFoundException;
import com.docbox.api.entity.Document;
import com.docbox.api.entity.DocumentImage;
import com.docbox.api.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	/*
	 * @Autowired private DocumentService documentService;
	 * 
	 * @PostMapping public ResponseEntity<Document> createDocument(@RequestBody
	 * Document document) { return
	 * ResponseEntity.ok(documentService.saveDocument(document)); }
	 * 
	 * @GetMapping("/user/{userId}") public ResponseEntity<List<Document>>
	 * getDocumentsByUserId(@PathVariable Long userId) { return
	 * ResponseEntity.ok(documentService.findByUserId(userId)); }
	 */

	
	@Autowired
    private DocumentService documentService;
	
	@Autowired
    private ObjectMapper objectMapper;

//    @PostMapping
//    public ResponseEntity<Document> addDocument(@RequestBody Document document) {
//        Document savedDocument = documentService.saveDocument(document);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
//    }

    @PostMapping
    public ResponseEntity<Document> addDocument(@RequestParam("documentType") String documentType,
            @RequestParam("userId") Long userId,
            @RequestParam("fields") String fieldsJson,
            @RequestParam(value = "images[]", required = false) List<String> imageUrls,
            @RequestParam("files") List<MultipartFile> files) throws IOException {
//    	Document savedDocument = documentService.saveDocument(document);
    	Map<String, Object> fields = objectMapper.readValue(fieldsJson, Map.class);
    	System.out.println(files);
    	return ResponseEntity.status(HttpStatus.CREATED).body(documentService.saveDocument(documentType, userId, fields, imageUrls, files));
    }
    
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        DocumentImage image = new DocumentImage();
        image.setName(file.getOriginalFilename());
//        image.setData(file.getBytes());
//        documentService.saveDocument(image);
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }
    
    @PutMapping("/{docId}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long docId, @RequestParam("documentType") String documentType,
            @RequestParam("userId") Long userId,
            @RequestParam("fields") String fieldsJson,
            @RequestParam("ids") String oldImageIds,
            @RequestParam("files") List<MultipartFile> files) throws IOException {
    	Map<String, Object> fields = objectMapper.readValue(fieldsJson, Map.class);
        Document updatedDocument = documentService.updateDocument(docId, documentType, userId, fields, files, oldImageIds);
        return ResponseEntity.ok(updatedDocument);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
    	try {
            documentService.deleteDocument(id);
            return ResponseEntity.ok("Document successfully deleted");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found with id = "+id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the document");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }
    
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Document>> getDocumentsByUserId(@PathVariable Long userId) {
        try {
            List<Document> documents = documentService.getDocumentsByUserId(userId);
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/user/{userId}/document/{documentId}")
    public ResponseEntity<?> getDocumentByUserIdAndDocumentId(
            @PathVariable Long userId, @PathVariable Long documentId) {
    	try {
            Document document = documentService.getDocumentByUserIdAndDocumentId(userId, documentId);
            return ResponseEntity.ok(document);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found for user with ID " + userId + " and document ID " + documentId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the document");
        }
    }
    // Add other CRUD operations as needed
}