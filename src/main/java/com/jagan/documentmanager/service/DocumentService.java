package com.jagan.documentmanager.service;

import com.jagan.documentmanager.entity.Document;
import com.jagan.documentmanager.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveDocument(
            String fileName,
            String s3Key,
            String contentType,
            Long fileSize
    ){

        Document document = new Document();
        document.setFileName(fileName);
        document.setContentType(contentType);
        document.setFileSize(fileSize);
        document.setS3Key(s3Key);
        document.setUploadTime(LocalDateTime.now());

        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments(){
        return documentRepository.findAll();
    }
}
