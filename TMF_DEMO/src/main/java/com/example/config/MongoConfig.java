package com.example.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
@EnableMongoRepositories(basePackages = "com.example.repository")
public class MongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;
    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Bean
    @Lazy
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = MongoClients.create(mongoUri);
        return new MongoTemplate(mongoClient, mongoDatabase);
    }

    @Bean
    @Lazy
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }
}