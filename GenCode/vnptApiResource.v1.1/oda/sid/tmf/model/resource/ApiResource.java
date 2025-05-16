package oda.sid.tmf.model.resource;

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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResource implements java.io.Serializable {
    @Id
    private String id;
    private String name;
    private String identifier;
    @ManyToOne
    @JoinColumn(name = "application_id")
    @JsonBackReference
    private ApplicationRef application;
    @OneToMany
    @JoinColumn(name = "ApiResource_id")
    @JsonManagedReference
    private List<ScopeRef> scope;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
}
