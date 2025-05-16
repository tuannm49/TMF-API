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
import oda.sid.vo.model.ContactMedium_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddressContactMedium_MVO extends ContactMedium_MVO implements java.io.Serializable {
    private String country;
    private String stateOrProvince;
    private String city;
    private String postCode;
    private String street1;
    private String street2;
    @ManyToOne
    @JoinColumn(name = "geographicAddress_id")
    @JsonBackReference
    private GeographicAddressRef_MVO geographicAddress;
}
