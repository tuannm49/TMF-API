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
public class UserAsset implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "UserAsset_id")
    @JsonManagedReference
    private List<Entitlement> entitlement;
    @Id
    private String id;
    private String role;
    private String entityType;
    private String assetType;
}
