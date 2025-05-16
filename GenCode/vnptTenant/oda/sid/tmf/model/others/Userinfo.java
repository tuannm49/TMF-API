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
public class Userinfo implements java.io.Serializable {
    private OffsetDateTime birthdate;
    private String email;
    private Boolean email_verified;
    private String family_name;
    private String gender;
    private String given_name;
    private String locale;
    private String middle_name;
    private String name;
    private String nickname;
    private String phone_number;
    private Boolean phone_number_verified;
    private String picture;
    private String preferred_username;
    private String profile;
    private String sub;
    private String website;
    private String zoneinfo;
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private GeographicAddress address;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<IndividualIdentification> legalId;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<UserAsset> userAssets;
}
