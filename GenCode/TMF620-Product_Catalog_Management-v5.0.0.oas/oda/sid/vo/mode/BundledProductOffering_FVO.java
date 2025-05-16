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
import oda.sid.vo.mode.ProductOfferingRef_FVO;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledProductOffering_FVO extends ProductOfferingRef_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "bundledProductOfferingOption_id")
    @JsonBackReference
    private BundledProductOfferingOption_FVO bundledProductOfferingOption;
}
