package oda.sid.tmf.model.product;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
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
public class BundledProductOfferingOption extends Extensible implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;    private Integer numberRelOfferDefault;
    private Integer numberRelOfferLowerLimit;
    private Integer numberRelOfferUpperLimit;
}
