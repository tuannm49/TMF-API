package oda.sid.vo.mode;

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
import oda.sid.vo.mode.Entity_FVO;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricingLogicAlgorithm_FVO extends Entity_FVO implements java.io.Serializable {
    private String name;
    private String description;
    private String plaSpecId;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
}
