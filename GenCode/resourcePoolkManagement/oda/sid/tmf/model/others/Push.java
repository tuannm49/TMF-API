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
import oda.sid.tmf.model.others.TaskResource;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Push extends TaskResource implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Push_id")
    @JsonManagedReference
    private List<ResourceRef> pushedResource;
}
