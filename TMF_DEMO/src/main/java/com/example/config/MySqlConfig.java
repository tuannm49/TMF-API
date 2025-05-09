package com.example.config;

import com.example.model.Product;
import com.example.model.User;
import com.example.repository.GenericRepository;
import com.example.repository.JpaGenericRepository;
import com.example.service.GenericService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mysql")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class MySqlConfig {

    @Bean
    public GenericRepository<User> userRepository(@Autowired EntityManager entityManager) {
        return new JpaGenericRepository<>(entityManager, User.class);
    }

    @Bean
    public GenericRepository<Product> productRepository(@Autowired EntityManager entityManager) {
        return new JpaGenericRepository<>(entityManager, Product.class);
    }

    @Bean
    public GenericService<User> userService(GenericRepository<User> userRepository) {
        return new GenericService<>(userRepository);
    }

    @Bean
    public GenericService<Product> productService(GenericRepository<Product> productRepository) {
        return new GenericService<>(productRepository);
    }
}