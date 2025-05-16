package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.product.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledGroupProductOffering extends Extensible implements java.io.Serializable {
    private String name;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    private String id;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_id")
    @JsonManagedReference
    private List<BundledProductOffering> bundledProductOffering;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    @JsonBackReference
    private BundledGroupProductOfferingOption bundledGroupProductOfferingOption;
}
