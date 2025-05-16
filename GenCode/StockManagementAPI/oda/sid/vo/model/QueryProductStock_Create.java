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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryProductStock_Create implements java.io.Serializable {
    private OffsetDateTime completedQueryProductStockDate;
    private OffsetDateTime creationDate;
    private Boolean instantSyncCheck;
    private OffsetDateTime requestedAvailabilityDate;
    private OffsetDateTime requestedQueryProductStockDate;
    @OneToMany
    @JoinColumn(name = "QueryProductStock_Create_id")
    @JsonManagedReference
    private List<ProductStock> queryProductStockItem;
    @OneToMany
    @JoinColumn(name = "QueryProductStock_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private ProductStock searchCriteria;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
