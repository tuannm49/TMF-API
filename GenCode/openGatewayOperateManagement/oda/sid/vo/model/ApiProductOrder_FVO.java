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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiProductOrder_FVO extends Entity implements java.io.Serializable {
    private String description;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalId;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_FVO_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_FVO_id")
    @JsonManagedReference
    private List<DCSProductOrderItem> productOrderItem;
}
