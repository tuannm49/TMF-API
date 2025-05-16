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
public class QuotePrice extends Extensible implements java.io.Serializable {
    private String unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;
    private String name;
    private String priceType;
    private String description;
    @ManyToOne
    @JoinColumn(name = "productOfferingPrice_id")
    @JsonBackReference
    private ProductOfferingPriceRef productOfferingPrice;
    private String recurringChargePeriod;
    @OneToMany
    @JoinColumn(name = "QuotePrice_id")
    @JsonManagedReference
    private List<PriceAlteration> priceAlteration;
}
