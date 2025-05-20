package oda.api.tmf.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Embeddable
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Money implements java.io.Serializable {
    private String unit;
    private String value;
}
