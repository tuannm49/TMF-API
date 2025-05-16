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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledGroupProductOffering_allOf implements java.io.Serializable {
    @Id
    private String id;
    private String name;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_allOf_id")
    @JsonManagedReference
    private List<BundledProductOffering> bundledProductOffering;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_allOf_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    @JsonBackReference
    private BundledGroupProductOfferingOption bundledGroupProductOfferingOption;
}
