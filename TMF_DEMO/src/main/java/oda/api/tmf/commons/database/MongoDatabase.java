package oda.api.tmf.commons.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import oda.api.tmf.commons.utils.YamlConfigLoader;
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
