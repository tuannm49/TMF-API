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
public class PermissionSet_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @ManyToOne
    @JoinColumn(name = "permissionSetSpecification_id")
    @JsonBackReference
    private PermissionSpecificationSetRef_MVO permissionSetSpecification;
    @OneToMany
    @JoinColumn(name = "PermissionSet_MVO_id")
    @JsonManagedReference
    private List<Permission_MVO> permission;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO user;
    @ManyToOne
    @JoinColumn(name = "granter_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO granter;
}
