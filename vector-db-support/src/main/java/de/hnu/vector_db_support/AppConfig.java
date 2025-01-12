package de.hnu.vector_db_support;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.allminilml6v2q.AllMiniLmL6V2QuantizedEmbeddingModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.chroma.ChromaEmbeddingStore;
import org.springframework.ai.autoconfigure.vectorstore.chroma.ChromaVectorStoreProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class AppConfig {

//    @Bean
//    EmbeddingModel embeddingModel() {
//        return OllamaEmbeddingModel.builder()
//                .baseUrl("http://localhost:11434")
//                .modelName("nomic-embed-text")
//                .build();
//    }

    @Bean
    EmbeddingStore<TextSegment> chromaEmbeddingStore() {
         return ChromaEmbeddingStore
                .builder()
                .baseUrl("http://localhost:8000")
                .collectionName(UUID.randomUUID().toString())
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    @Bean
    public AllMiniLmL6V2QuantizedEmbeddingModel embeddingModel() {
        return new AllMiniLmL6V2QuantizedEmbeddingModel();
    }

}
