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
import oda.sid.tmf.model.others.PaymentMethod;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirectDebit extends PaymentMethod implements java.io.Serializable {
    private String owner;
    private String accountNumberType;
    private String signature;
    @JsonProperty("@type")
    private String type;
    private String accountNumber;
    private String reference;
    private String bank;
    private String mandateCategory;
    private OffsetDateTime signatureDate;
    private OffsetDateTime lastDebitDate;
    @OneToMany
    @JoinColumn(name = "DirectDebit_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private String mandateType;
    private String mandateStatus;
    private String mandateId;
    private OffsetDateTime firstDebitDate;
    private OffsetDateTime mandateStatusDate;
    private String BIC;
    private OffsetDateTime cancellationDate;
}
