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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Monitor_FVO extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "request_id")
    @JsonBackReference
    private Request request;
    private String state;
    private String sourceHref;
    @ManyToOne
    @JoinColumn(name = "response_id")
    @JsonBackReference
    private Response response;
}
