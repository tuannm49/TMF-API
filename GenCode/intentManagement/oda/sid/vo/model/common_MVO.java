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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class common_MVO implements java.io.Serializable {
    @JsonProperty("@id")
    private String id;
    @JsonProperty("@value")
    private String value;
    @JsonProperty("@language")
    private String language;
    @JsonProperty("@container")
    private String container;
    @JsonProperty("@list")
    private Object list;
    @JsonProperty("@set")
    private Object set;
    @JsonProperty("@reverse")
    private Object reverse;
    @JsonProperty("@base")
    private String base;
    @JsonProperty("@vocab")
    private String vocab;
}
