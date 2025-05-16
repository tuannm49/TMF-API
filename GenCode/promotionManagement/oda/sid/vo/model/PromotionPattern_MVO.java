package oda.sid.vo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionPattern_MVO implements java.io.Serializable {
    private String description;
    private Integer priority;
    private String relationTypeAmongGroup;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_MVO_id")
    @JsonManagedReference
    private List<PromotionAction_MVO> action;
    @OneToMany
    @JoinColumn(name = "PromotionPattern_MVO_id")
    @JsonManagedReference
    private List<PromotionCriteriaGroup_MVO> criteriaGroup;
    private String name;
}
