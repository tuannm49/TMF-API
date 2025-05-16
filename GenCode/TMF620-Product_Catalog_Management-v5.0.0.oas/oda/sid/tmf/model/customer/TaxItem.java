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
import lombok.Data;
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxItem extends Extensible implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "taxAmount_id")
    @JsonBackReference
    private Money taxAmount;
    private Object taxRate;
    private String taxCategory;
}
