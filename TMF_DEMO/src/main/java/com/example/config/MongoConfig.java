package com.example.config;

import com.example.model.Product;
import com.example.model.User;
import com.example.repository.GenericRepository;
import com.example.repository.MongoGenericRepository;
import com.example.service.GenericService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
@EnableMongoRepositories(basePackages = "com.example.repository")
public class MongoConfig {

//    @Bean
//    public GenericRepository<User> userRepository(MongoTemplate mongoTemplate) {
//        return new MongoGenericRepository<>(mongoTemplate, User.class);
//    }
//
//    @Bean
//    public GenericRepository<Product> productRepository(MongoTemplate mongoTemplate) {
//        return new MongoGenericRepository<>(mongoTemplate, Product.class);
//    }
//
//    @Bean
//    public GenericService<User> userService(GenericRepository<User> userRepository) {
//        return new GenericService<>(userRepository);
//    }
//
//    @Bean
//    public GenericService<Product> productService(GenericRepository<Product> productRepository) {
//        return new GenericService<>(productRepository);
//    }
}