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
public class PolicyConditionStatement implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PolicyConditionStatement_id")
    @JsonManagedReference
    private List<PolicyConditionValue> PolicyConditionValue;
    @ManyToOne
    @JoinColumn(name = "PolicyConditionVariable_id")
    @JsonBackReference
    private PolicyConditionVariable PolicyConditionVariable;
    @JsonProperty("@type")
    private String type;
    private String opType;
    private String name;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
