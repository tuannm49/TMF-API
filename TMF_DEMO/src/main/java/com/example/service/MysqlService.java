package com.example.service;

import com.example.commons.repository.MysqlRepository;
import com.example.commons.service.GenericService;
import com.example.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mysql")
public class MysqlService implements AbstractService{
    @Autowired
    private JpaTransactionManager transactionManager;

    public GenericService<Product> getProductService(){
        EntityManagerFactory entityManagerFactory =  transactionManager.getEntityManagerFactory();
        MysqlRepository<Product> repository = new MysqlRepository<>(entityManagerFactory.createEntityManager(),Product.class);
        return new GenericService<>(repository,Product.class);
    }
}
