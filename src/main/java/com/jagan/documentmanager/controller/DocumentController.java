package com.jagan.documentmanager.controller;

import com.jagan.documentmanager.entity.Document;
import com.jagan.documentmanager.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(){

        Document saveDoument = documentService.saveDocument(
                "test-file.pdf",
                "documents/test-file.pdf",
                12345L,
                "application/pdf"
        );

        return new ResponseEntity<>(saveDoument, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocument(){
        return ResponseEntity.ok(documentService.getAllDocuments());
    }
}
