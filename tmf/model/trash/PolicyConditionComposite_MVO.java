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
public class PolicyConditionComposite_MVO implements java.io.Serializable {
    private Boolean isResultNegated;
    @OneToMany
    @JoinColumn(name = "PolicyConditionComposite_MVO_id")
    @JsonManagedReference
    private List<PolicyConditionRefOrValue_MVO> condition;
    private String conditionCombinationLogic;
    @JsonProperty("@type")
    private String type;
}
