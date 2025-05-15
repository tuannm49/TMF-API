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
public class CheckPermission implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "permissionSpecification_id")
    @JsonBackReference
    private PermissionSpecificationRefOrValue permissionSpecification;
    @JsonProperty("@type")
    private String type;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef user;
    @OneToMany
    @JoinColumn(name = "CheckPermission_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "CheckPermission_id")
    @JsonManagedReference
    private List<EntityRefOrValue> entity;
}
