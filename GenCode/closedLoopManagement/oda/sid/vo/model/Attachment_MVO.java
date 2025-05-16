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
public class Attachment_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "size_id")
    @JsonBackReference
    private Quantity size;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String attachmentType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    private String mimeType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String url;
    private String content;
}
