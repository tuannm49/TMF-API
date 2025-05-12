package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Properties;

@Configuration
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mysql")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class MySqlConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/serviceInvtory?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("rootpassword");
        dataSource.setMaximumPoolSize(10);
        dataSource.setMinimumIdle(2);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.generate_statistics", "false");
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}