package oda.sid.tmf.model.party;

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
public class Organization implements java.io.Serializable {
    @Id
    private String id;
    private String orgName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @JsonBackReference
    private TenantRef tenant;
    @ManyToOne
    @JoinColumn(name = "orgParent_id")
    @JsonBackReference
    private OrganizationRef orgParent;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
}
