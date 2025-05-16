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
import java.time.OffsetDateTime;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlternateProductOfferingProposal implements java.io.Serializable {
    @Id
    private String id;
    private OffsetDateTime alternateActivationDate;
    @ManyToOne
    @JoinColumn(name = "alternateProduct_id")
    @JsonBackReference
    private ProductRefOrValue alternateProduct;
    @ManyToOne
    @JoinColumn(name = "alternateProductOffering_id")
    @JsonBackReference
    private ProductOfferingRef alternateProductOffering;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
