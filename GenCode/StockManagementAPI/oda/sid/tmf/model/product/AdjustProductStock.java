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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdjustProductStock implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String adjustReason;
    private OffsetDateTime completedAdjustProductStockDate;
    private OffsetDateTime creationDate;
    private String description;
    private Boolean instantSyncAdjust;
    private OffsetDateTime requestedAdjustProductStockDate;
    @OneToMany
    @JoinColumn(name = "AdjustProductStock_id")
    @JsonManagedReference
    private List<AdjustProductStockItem> adjustProductStockItem;
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
