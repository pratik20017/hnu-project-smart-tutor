package de.hnu.vector_db_support.controllers;


import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.loader.UrlDocumentLoader;
import dev.langchain4j.model.embedding.onnx.allminilml6v2q.AllMiniLmL6V2QuantizedEmbeddingModel;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/embedding")
public class DocumentController {

    private final AllMiniLmL6V2QuantizedEmbeddingModel embeddingModel;

    public DocumentController(AllMiniLmL6V2QuantizedEmbeddingModel minEmbedModel) {
        this.embeddingModel = minEmbedModel;
    }

    @PostMapping("/upload")
    public void index(@RequestParam("files") MultipartFile[] files) {

        try {
            Path uploadDir = Paths.get("uploaded_files");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
//        if (embeddingModel.estimateTokenCount(query.query()) > 2024) {
//
//        }
//        Response<Embedding> embed = embeddingModel.embed(query.query());
//        String addResult = embeddingStore.add(embed.content());
    }

//    @PostMapping("/search")
//    public ResponseEntity<Document> search(@RequestBody Query query) {
//        Response<Embedding> embed = embeddingModel.embed(query.query());
//        EmbeddingSearchResult searchResult = embeddingStore.search(EmbeddingSearchRequest.builder().
//                queryEmbedding(embed.content()).build());
//
//        searchResult.matches().toArray();
//    }
}