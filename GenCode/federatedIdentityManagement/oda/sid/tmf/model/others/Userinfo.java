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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Userinfo implements java.io.Serializable {
    private String sub;
    private String name;
    private String family_name;
    private String given_name;
    private String middle_name;
    private String nickname;
    private String preferred_username;
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private GeographicAddress address;
    private String birthdate;
    private String email;
    private Boolean email_verified;
    private String gender;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<IndividualIdentification> legalId;
    private String locale;
    private String phone_number;
    private Boolean phone_number_verified;
    private String picture;
    private String profile;
    private String website;
    private String zoneinfo;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<PermissionSetRef> userPermission;
}
