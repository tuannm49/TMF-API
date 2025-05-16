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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentAlarm extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CommentAlarm_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> commentedAlarm;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JsonBackReference
    private Comment comment;
    private String id;
    private String href;
    private String state;
    @OneToMany
    @JoinColumn(name = "CommentAlarm_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> alarmPattern;
}
