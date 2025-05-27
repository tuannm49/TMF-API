package oda.api.tmf.commons.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Embeddable
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Duration implements java.io.Serializable {
    private Integer amount;
    private String units;
}
