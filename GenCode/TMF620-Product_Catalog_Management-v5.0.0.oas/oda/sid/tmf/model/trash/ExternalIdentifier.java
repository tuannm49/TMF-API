package oda.sid.tmf.model.trash;

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
import oda.sid.tmf.model.trash.Extensible;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalIdentifier extends Extensible implements java.io.Serializable {
    private String owner;
    private String externalIdentifierType;
    private String id;
}
