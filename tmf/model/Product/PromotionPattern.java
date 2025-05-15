package com.example.Product;

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
public class PromotionPattern implements java.io.Serializable {
    private String relationTypeAmongGroup;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_id")
    @JsonManagedReference
    private List<PromotionCriteriaGroup> criteriaGroup;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_id")
    @JsonManagedReference
    private List<PromotionAction> action;
    @Id
    private String id;
    private Integer priority;
}
