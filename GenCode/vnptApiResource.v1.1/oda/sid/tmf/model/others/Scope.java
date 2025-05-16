package oda.sid.tmf.model.others;

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
import java.time.OffsetDateTime;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scope implements java.io.Serializable {
    @Id
    private String id;
    private String name;
    private String displayName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "apiResource_id")
    @JsonBackReference
    private ApiResourceRef apiResource;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
}
