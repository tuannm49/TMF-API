package com.example.service;

import com.example.commons.repository.MongoRepository;
import com.example.commons.repository.MysqlRepository;
import com.example.commons.service.GenericService;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
public class MongoService implements AbstractService{
    @Autowired
    private MongoTemplate mongoTemplate;
    public GenericService<Product> getProductService(){
        MongoRepository<Product>repository = new MongoRepository<>(mongoTemplate,Product.class);
        return new GenericService<>(repository,Product.class);
    }
}
