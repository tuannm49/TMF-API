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
import java.time.OffsetDateTime;
import oda.sid.vo.model.EntitySpecification_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopSpecification_MVO extends EntitySpecification_MVO implements java.io.Serializable {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "closedLoopGroup_id")
    @JsonBackReference
    private ClosedLoopGroup_MVO closedLoopGroup;
    private OffsetDateTime creationdate;
    private OffsetDateTime validfor;
    @ManyToOne
    @JoinColumn(name = "closedLoopType_id")
    @JsonBackReference
    private ClosedLoopType closedLoopType;
}
