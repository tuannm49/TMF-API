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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission_FVO extends Extensible_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "permissionSpecificationSet_id")
    @JsonBackReference
    private PermissionSpecificationSetRef_FVO permissionSpecificationSet;
    @ManyToOne
    @JoinColumn(name = "managedAssetGroup_id")
    @JsonBackReference
    private AssetGroup_FVO managedAssetGroup;
    @ManyToOne
    @JoinColumn(name = "permissionSpecification_id")
    @JsonBackReference
    private PermissionSpecificationRefOrValue_FVO permissionSpecification;
    @OneToMany
    @JoinColumn(name = "Permission_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
}
