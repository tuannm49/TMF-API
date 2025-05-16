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
public class PromotionCriteriaGroup_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PromotionCriteriaGroup_FVO_id")
    @JsonManagedReference
    private List<PromotionCriteria_FVO> criteria;
    private String groupName;
    private String criteriaLogicalRelationship;
}
