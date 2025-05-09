package vnpt.oda.tmf638.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(name = "app.datasource", havingValue = "mongodb")
@EnableMongoRepositories(basePackages = "vnpt.oda.tmf638.mongo.repository")
public class MongoConfig {
}
