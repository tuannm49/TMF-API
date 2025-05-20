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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledGroupProductOffering extends Extensible implements java.io.Serializable {
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BundledGroupProductOffering_id")
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BundledGroupProductOffering_id")
    private List<BundledProductOffering> bundledProductOffering;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    private BundledGroupProductOfferingOption bundledGroupProductOfferingOption;
}
