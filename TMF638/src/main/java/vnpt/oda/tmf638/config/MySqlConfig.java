package vnpt.oda.tmf638.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "app.datasource", havingValue = "mysql", matchIfMissing = true)
@EntityScan(basePackages = "vnpt.oda.tmf638.entity")
@EnableJpaRepositories(basePackages = "vnpt.oda.tmf638.repository")
public class MySqlConfig {
}
