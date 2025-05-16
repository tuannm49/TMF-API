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
import oda.sid.vo.model.ServiceQualification_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckServiceQualification_MVO extends ServiceQualification_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckServiceQualification_MVO_id")
    @JsonManagedReference
    private List<CheckServiceQualificationItem_MVO> serviceQualificationItem;
    private Boolean provideResultReason;
    private Boolean provideAlternative;
}
