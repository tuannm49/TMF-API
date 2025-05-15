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
public class PromotionPattern_MVO implements java.io.Serializable {
    private String relationTypeAmongGroup;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_MVO_id")
    @JsonManagedReference
    private List<PromotionCriteriaGroup_MVO> criteriaGroup;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_MVO_id")
    @JsonManagedReference
    private List<PromotionAction_MVO> action;
    private Integer priority;
}
