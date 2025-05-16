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
import java.time.OffsetDateTime;
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillCycle_MVO extends Entity_MVO implements java.io.Serializable {
    private OffsetDateTime billingDate;
    private OffsetDateTime paymentDueDate;
    private OffsetDateTime creditDate;
    private String billingPeriod;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    private OffsetDateTime mailingDate;
    private OffsetDateTime chargeDate;
    @ManyToOne
    @JoinColumn(name = "BillCycleSpecification_id")
    @JsonBackReference
    private BillCycleSpecificationRef BillCycleSpecification;
}
