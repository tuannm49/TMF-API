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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capacity_FVO extends Entity_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Capacity_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRef_FVO> relatedPlace;
    @ManyToOne
    @JoinColumn(name = "capacitySpecification_id")
    @JsonBackReference
    private CapacitySpecificationRef_FVO capacitySpecification;
    private String rangeInterval;
    @ManyToOne
    @JoinColumn(name = "capacityStatus_id")
    @JsonBackReference
    private CapacityStatus capacityStatus;
    @OneToMany
    @JoinColumn(name = "Capacity_FVO_id")
    @JsonManagedReference
    private List<ApplicableTimePeriod_FVO> applicableTimePeriod;
    @OneToMany
    @JoinColumn(name = "Capacity_FVO_id")
    @JsonManagedReference
    private List<Capacity_FVO> relatedCapacity;
    @ManyToOne
    @JoinColumn(name = "capacityAmountTo_id")
    @JsonBackReference
    private Quantity capacityAmountTo;
    private String name;
    @OneToMany
    @JoinColumn(name = "Capacity_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> capacityCharacteristic;
    @ManyToOne
    @JoinColumn(name = "capacityAmount_id")
    @JsonBackReference
    private Quantity capacityAmount;
    @ManyToOne
    @JoinColumn(name = "capacityAmountFrom_id")
    @JsonBackReference
    private Quantity capacityAmountFrom;
}
