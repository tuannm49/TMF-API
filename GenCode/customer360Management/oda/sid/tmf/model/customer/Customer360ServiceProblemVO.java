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
import java.util.List;
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer360ServiceProblemVO extends Entity implements java.io.Serializable {
    private String description;
    private String category;
    private Integer priority;
    private String originatingSystem;
    @OneToMany
    @JoinColumn(name = "Customer360ServiceProblemVO_id")
    @JsonManagedReference
    private List<ServiceRef> affectedService;
    private String status;
}
