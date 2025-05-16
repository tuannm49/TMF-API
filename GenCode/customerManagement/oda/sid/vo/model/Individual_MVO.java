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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Party_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Individual_MVO extends Party_MVO implements java.io.Serializable {
    private String gender;
    private String aristocraticTitle;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<Disability> disability;
    private String formattedName;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<IndividualIdentification_MVO> individualIdentification;
    private String title;
    private String legalName;
    private String countryOfBirth;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<Skill> skill;
    private String familyName;
    private OffsetDateTime deathDate;
    private String generation;
    private String placeOfBirth;
    private String givenName;
    private OffsetDateTime birthDate;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<LanguageAbility> languageAbility;
    private String nationality;
    private String preferredGivenName;
    private String familyNamePrefix;
    private String name;
    private String middleName;
    private String location;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<OtherNameIndividual> otherName;
    private String maritalStatus;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private IndividualStateType status;
}
