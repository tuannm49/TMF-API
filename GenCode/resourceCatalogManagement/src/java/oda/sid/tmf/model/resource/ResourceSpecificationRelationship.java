package oda.sid.tmf.model.resource;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceSpecificationRelationship extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String role;
    private String relationshipType;
    @Embedded
    private TimePeriod validFor;
    private String name;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String href;
    private Integer defaultQuantity;
    private Integer minimumQuantity;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecificationRelationship_CharacteristicSpecification")
    private List<CharacteristicSpecification> characteristic;
    private Integer maximumQuantity;
}
