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
public class Permission implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "permissionSpecificationSet_id")
    @JsonBackReference
    private PermissionSpecificationSetRef permissionSpecificationSet;
    @ManyToOne
    @JoinColumn(name = "managedAssetGroup_id")
    @JsonBackReference
    private AssetGroup managedAssetGroup;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "permissionSpecification_id")
    @JsonBackReference
    private PermissionSpecificationRefOrValue permissionSpecification;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Permission_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
}
