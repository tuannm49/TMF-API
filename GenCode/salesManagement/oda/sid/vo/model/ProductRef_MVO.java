package oda.sid.vo.model;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRef_MVO implements java.io.Serializable {
    @JsonProperty("@referredType")
    private String referredType;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
