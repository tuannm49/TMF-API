package oda.sid.vo.model;

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
public class BundledGroupProductOffering_FVO extends Extensible_FVO implements java.io.Serializable {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BundledGroupProductOffering_FVO_id")
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    private BundledGroupProductOfferingOption_FVO bundledGroupProductOfferingOption;
}
