package oda.api.tmf.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Embeddable
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quantity implements java.io.Serializable {
    private String amount;
    private String units;
}
