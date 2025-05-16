package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingCart extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<CartPrice> cartTotalPrice;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<CartItem> cartItem;
}
