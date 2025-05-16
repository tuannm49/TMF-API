package oda.sid.tmf.model.resource;

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
import oda.sid.tmf.model.resource.Resource;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhysicalResource extends Resource implements java.io.Serializable {
    private OffsetDateTime manufactureDate;
    private String powerState;
    private String serialNumber;
    private String versionNumber;
}
