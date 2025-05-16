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
import oda.sid.tmf.model.others.Activity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopActivity extends Activity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef ingressPoint;
    @ManyToOne
    @JoinColumn(name = "closedLoop_id")
    @JsonBackReference
    private ClosedLoopRef closedLoop;
    @ManyToOne
    @JoinColumn(name = "closedLoopActivitySpecification_id")
    @JsonBackReference
    private EntitySpecificationRef closedLoopActivitySpecification;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef egressPoint;
}
