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
public class PartyRevSharingAlgorithm implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PartyRevSharingPolicyActionVariable> actionVariable;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PartyRevSharingPolicyConditionVariable> conditionVariable;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
}
