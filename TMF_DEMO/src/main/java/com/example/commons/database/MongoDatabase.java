package com.example.commons.database;

import com.example.commons.utils.YamlConfigLoader;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Map;

public class MongoDatabase {
    private static final Map<String, Object> config = YamlConfigLoader.loadConfig("application.yml");
    public static MongoTemplate mongoTemplate() {
        String mongoUri = YamlConfigLoader.getNestedValue(config, "spring", "data", "mongodb","uri");//"mongodb://localhost:27017/service_inventory";
        String mongoDatabase = YamlConfigLoader.getNestedValue(config, "spring", "data", "mongodb","database");//"service_inventory";
        MongoClient mongoClient = MongoClients.create(mongoUri);
        return new MongoTemplate(mongoClient, mongoDatabase);
    }

}
