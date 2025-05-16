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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonLdExpressionValue_MVO implements java.io.Serializable {
    @JsonProperty("@base")
    private String base;
    @JsonProperty("@value")
    private String value;
    @JsonProperty("@vocab")
    private String vocab;
    @JsonProperty("@language")
    private String language;
    @JsonProperty("@list")
    private Object list;
    @JsonProperty("@graph")
    @OneToMany
    @JoinColumn(name = "JsonLdExpressionValue_MVO_id")
    @JsonManagedReference
    private List<common_MVO> graph;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("@reverse")
    private Object reverse;
    @JsonProperty("@container")
    private String container;
    @JsonProperty("@set")
    private Object set;
    @JsonProperty("@context")
    private Object context;
}
