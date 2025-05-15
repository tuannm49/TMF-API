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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User_Create implements java.io.Serializable {
    private String password;
    @ManyToOne
    @JoinColumn(name = "dataOwnerOrganization_id")
    @JsonBackReference
    private OrganizationRef dataOwnerOrganization;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    @JsonBackReference
    private OrganizationRef organization;
    @OneToMany
    @JoinColumn(name = "User_Create_id")
    @JsonManagedReference
    private List<RoleRef> roles;
    private String name;
    @OneToMany
    @JoinColumn(name = "User_Create_id")
    @JsonManagedReference
    private List<GroupRef> groups;
    private String userName;
    private Boolean isActive;
    private String email;
}
