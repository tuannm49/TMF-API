package oda.sid.tmf.model.common;

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
import oda.sid.tmf.model.common.Entity;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "size_id")
    @JsonBackReference
    private Quantity size;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String attachmentType;
    private String name;
    private String description;
    private String mimeType;
    private String url;
    private String content;
}
