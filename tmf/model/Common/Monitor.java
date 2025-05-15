package com.example.Common;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Monitor implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "request_id")
    @JsonBackReference
    private Request request;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "response_id")
    @JsonBackReference
    private Response response;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    private String href;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String sourceHref;
}
