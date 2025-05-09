package vnpt.oda.tmf638.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class DataSourceConfig {
    private String datasource; // mysql, mongodb, or both
}
