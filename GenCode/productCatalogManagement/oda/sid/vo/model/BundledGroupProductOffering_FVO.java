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
public class BundledGroupProductOffering_FVO extends Extensible_FVO implements java.io.Serializable {
    private String name;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    private String id;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    @JsonBackReference
    private BundledGroupProductOfferingOption_FVO bundledGroupProductOfferingOption;
}
