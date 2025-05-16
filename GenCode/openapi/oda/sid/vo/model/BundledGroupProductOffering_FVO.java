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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledGroupProductOffering_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    @JsonBackReference
    private BundledGroupProductOfferingOption_FVO bundledGroupProductOfferingOption;
    @JsonProperty("@type")
    private String type;
    private String name;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
