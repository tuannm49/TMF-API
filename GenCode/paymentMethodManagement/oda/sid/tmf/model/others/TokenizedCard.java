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
import oda.sid.tmf.model.others.PaymentMethod;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenizedCard extends PaymentMethod implements java.io.Serializable {
    private String countryOfIssue;
    private String lastFourDigits;
    @JsonProperty("@type")
    private String type;
    private String cardType;
    private String tokenType;
    private String brand;
    private String issuer;
    private String token;
    private OffsetDateTime expirationDate;
}
