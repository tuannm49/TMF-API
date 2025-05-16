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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckProductConfigurationItem_FVO extends Extensible_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckProductConfigurationItem_FVO_id")
    @JsonManagedReference
    private List<ProductConfigurationItemRelationship_FVO> productConfigurationItemRelationship;
    @ManyToOne
    @JoinColumn(name = "productConfiguration_id")
    @JsonBackReference
    private ProductConfiguration_FVO productConfiguration;
    private String id;
    private String state;
    @ManyToOne
    @JoinColumn(name = "contextItem_id")
    @JsonBackReference
    private ItemRef_FVO contextItem;
    @OneToMany
    @JoinColumn(name = "CheckProductConfigurationItem_FVO_id")
    @JsonManagedReference
    private List<CheckProductConfigurationItem_FVO> productConfigurationItem;
    @OneToMany
    @JoinColumn(name = "CheckProductConfigurationItem_FVO_id")
    @JsonManagedReference
    private List<ProductConfiguration_FVO> alternateProductConfigurationProposal;
    @OneToMany
    @JoinColumn(name = "CheckProductConfigurationItem_FVO_id")
    @JsonManagedReference
    private List<StateReason_FVO> stateReason;
}
