package oda.sid.tmf.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import oda.sid.tmf.model.product.EntityRef;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRef extends EntityRef implements java.io.Serializable {
    private String id;
    private String href;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String version;
    @JsonProperty("@type")
    private String type;
}
