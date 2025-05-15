package com.example.trash;

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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiVersionDetails implements java.io.Serializable {
    private Integer apiMajorVersion;
    @JsonProperty("@baseType")
    private String baseType;
    private String basePath;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "countryCode_id")
    @JsonBackReference
    private ISO31661Alpha2StandardIdentifier countryCode;
    @OneToMany
    @JoinColumn(name = "ApiVersionDetails_id")
    @JsonManagedReference
    private List<ApiGrantInformation> apiGrantInformation;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
