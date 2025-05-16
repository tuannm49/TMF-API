package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillStructure extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "BillStructure_id")
    @JsonManagedReference
    private List<BillPresentationMediaRefOrValue> presentationMedia;
    @ManyToOne
    @JoinColumn(name = "format_id")
    @JsonBackReference
    private BillFormatRefOrValue format;
    @ManyToOne
    @JoinColumn(name = "cycleSpecification_id")
    @JsonBackReference
    private BillingCycleSpecificationRefOrValue cycleSpecification;
}
