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
public class Userinfo implements java.io.Serializable {
    private String sub;
    private String website;
    private String zoneinfo;
    private OffsetDateTime birthdate;
    private Boolean email_verified;
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private GeographicAddress address;
    private String gender;
    private String profile;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<IndividualIdentification> legalId;
    private Boolean phone_number_verified;
    private String preferred_username;
    private String given_name;
    private String locale;
    private String middle_name;
    private String picture;
    @OneToMany
    @JoinColumn(name = "Userinfo_id")
    @JsonManagedReference
    private List<UserAsset> userAssets;
    private String name;
    private String nickname;
    private String phone_number;
    private String family_name;
    private String email;
}
