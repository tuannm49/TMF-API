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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization_Create implements java.io.Serializable {
    private String description;
    private String orgName;
    @ManyToOne
    @JoinColumn(name = "orgParent_id")
    @JsonBackReference
    private OrganizationRef orgParent;
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @JsonBackReference
    private TenantRef tenant;
}
