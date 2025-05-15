package com.example.trash;

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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackingDetailsType implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "TrackingDetailsType_id")
    @JsonManagedReference
    private List<CheckpointType> checkpoint;
    private Object weight;
    private String trackingCode;
    private OffsetDateTime trackingDate;
    private OffsetDateTime estimatedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "addressTo_id")
    @JsonBackReference
    private AddressType addressTo;
    private OffsetDateTime statusChangeDate;
    private String carrier;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "addressFrom_id")
    @JsonBackReference
    private AddressType addressFrom;
    private String carrierTrackingUrl;
    private String status;
    @OneToMany
    @JoinColumn(name = "TrackingDetailsType_id")
    @JsonManagedReference
    private List<OrderRefType> order;
}
