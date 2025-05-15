package com.example.Common;

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
public class User implements java.io.Serializable {
    private String password;
    private OffsetDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "dataOwnerOrganization_id")
    @JsonBackReference
    private OrganizationRef dataOwnerOrganization;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    @JsonBackReference
    private OrganizationRef organization;
    @OneToMany
    @JoinColumn(name = "User_id")
    @JsonManagedReference
    private List<RoleRef> roles;
    private String name;
    @OneToMany
    @JoinColumn(name = "User_id")
    @JsonManagedReference
    private List<GroupRef> groups;
    @Id
    private String id;
    private OffsetDateTime updatedDate;
    private String userName;
    private Boolean isActive;
    private String email;
}
