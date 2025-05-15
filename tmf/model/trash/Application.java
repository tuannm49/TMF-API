package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application implements java.io.Serializable {
    private OffsetDateTime createdDate;
    private String accessUrl;
    @OneToMany
    @JoinColumn(name = "Application_id")
    @JsonManagedReference
    private List<RoleRef> roles;
    private String name;
    private String description;
    private String logo;
    @Id
    private String id;
    private OffsetDateTime updatedDate;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @JsonBackReference
    private TenantRef tenant;
}
