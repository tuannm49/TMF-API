package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capacity extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Capacity_id")
    @JsonManagedReference
    private List<RelatedPlaceRef> relatedPlace;
    @ManyToOne
    @JoinColumn(name = "capacitySpecification_id")
    @JsonBackReference
    private CapacitySpecificationRef capacitySpecification;
    private String rangeInterval;
    @ManyToOne
    @JoinColumn(name = "capacityStatus_id")
    @JsonBackReference
    private CapacityStatus capacityStatus;
    @OneToMany
    @JoinColumn(name = "Capacity_id")
    @JsonManagedReference
    private List<ApplicableTimePeriod> applicableTimePeriod;
    @OneToMany
    @JoinColumn(name = "Capacity_id")
    @JsonManagedReference
    private List<Capacity> relatedCapacity;
    @ManyToOne
    @JoinColumn(name = "capacityAmountTo_id")
    @JsonBackReference
    private Quantity capacityAmountTo;
    private String name;
    @OneToMany
    @JoinColumn(name = "Capacity_id")
    @JsonManagedReference
    private List<Characteristic> capacityCharacteristic;
    @ManyToOne
    @JoinColumn(name = "capacityAmount_id")
    @JsonBackReference
    private Quantity capacityAmount;
    @ManyToOne
    @JoinColumn(name = "capacityAmountFrom_id")
    @JsonBackReference
    private Quantity capacityAmountFrom;
}
