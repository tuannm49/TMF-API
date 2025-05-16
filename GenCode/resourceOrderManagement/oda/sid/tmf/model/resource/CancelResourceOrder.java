package oda.sid.tmf.model.resource;

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
public class CancelResourceOrder implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String cancellationReason;
    private OffsetDateTime effectiveCancellationDate;
    private OffsetDateTime requestedCancellationDate;
    @ManyToOne
    @JoinColumn(name = "resourceOrder_id")
    @JsonBackReference
    private ResourceOrderRef resourceOrder;
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
