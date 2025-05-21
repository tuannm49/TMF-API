package oda.api.tmf.commons.database;

import oda.api.tmf.commons.utils.YamlConfigLoader;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

public class DbmsDatabase {
    private static final Map<String, Object> config = YamlConfigLoader.loadConfig("application.yml");

    public static DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "driver-class-name"));
        dataSource.setJdbcUrl(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "url"));
        dataSource.setUsername(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "username"));
        dataSource.setPassword(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "password"));
        dataSource.setMaximumPoolSize(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "hikari", "maximum-pool-size"));
        dataSource.setMinimumIdle(YamlConfigLoader.getNestedValue(config, "spring", "datasource", "hikari", "minimum-idle"));
        return dataSource;
    }

    public static EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan((String)YamlConfigLoader.getNestedValue(config, "spring", "jpa", "packages-to-scan"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        em.afterPropertiesSet();
        return em.getObject();
    }

    private static Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", YamlConfigLoader.getNestedValue(config, "spring", "jpa", "hibernate", "ddl-auto"));
        properties.setProperty("hibernate.show_sql", String.valueOf((Boolean) YamlConfigLoader.getNestedValue(config, "spring", "jpa", "show-sql")));
        properties.setProperty("hibernate.generate_statistics", String.valueOf((Boolean)  YamlConfigLoader.getNestedValue(config, "spring", "jpa",  "generate_statistics")));
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }
}
