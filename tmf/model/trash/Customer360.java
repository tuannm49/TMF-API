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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer360 implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360ServiceProblemVO> serviceProblem;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360ProductVO> product;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360AgreementVO> agreement;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360CustomerBillVO> customerBill;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360ProductOrderVO> productOrder;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360RecommendationVO> recommendation;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360AppointmentVO> appointment;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360TroubleTicketVO> troubleTicket;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360PartyInteractionVO> partyInteraction;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360QuoteVO> quote;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360PaymentMethodVO> paymentMethod;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360AccountVO> account;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer360CustomerVO customer;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360LoyaltyAccountVO> loyaltyAccount;
    @OneToMany
    @JoinColumn(name = "Customer360_id")
    @JsonManagedReference
    private List<Customer360PromotionVO> promotion;
}
