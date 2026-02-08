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
            long fileSize,
            String contentType

    ){

        Document document = new Document();
        document.setFileName(fileName);
        document.setS3Key(s3Key);
        document.setFileSize(fileSize);
        document.setContentType(contentType);
        document.setUploadTime(LocalDateTime.now());

        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments(){
        return documentRepository.findAll();
    }
}
