package oda.sid.tmf.model.others;

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
public class TrackingRequestType implements java.io.Serializable {
    private String carrier;
    private String trackingCode;
    private String carrierTrackingUrl;
    private OffsetDateTime trackingDate;
    private String status;
    private OffsetDateTime statusChangeDate;
    private String statusChangeReason;
    private Object weight;
    private OffsetDateTime estimatedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "addressFrom_id")
    @JsonBackReference
    private AddressType addressFrom;
    @ManyToOne
    @JoinColumn(name = "addressTo_id")
    @JsonBackReference
    private AddressType addressTo;
    @OneToMany
    @JoinColumn(name = "TrackingRequestType_id")
    @JsonManagedReference
    private List<CheckpointType> checkpoint;
    @OneToMany
    @JoinColumn(name = "TrackingRequestType_id")
    @JsonManagedReference
    private List<OrderRefType> order;
}
