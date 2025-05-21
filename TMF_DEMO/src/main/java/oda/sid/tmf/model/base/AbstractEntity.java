package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import oda.sid.tmf.model.base.annotation.VersionProperty;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahman.barzideh
 *
 */
@MappedSuperclass
@Data
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


//    @Id
//    @Column(name = "VERSION", nullable = false)
//    @VersionProperty
//    private String version;
//
//    @Transient
//    @JsonIgnore
//    private ParsedVersion parsedVersion;

    private String href;
    private String name;
    private String description;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@referredType")
    private String referredType;
    private String version;
//    @Column(name = "LAST_UPDATE", nullable = true)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastUpdate;
//
//    @Column(name = "LIFECYCLE_STATUS", nullable = true)
//    private LifecycleStatus lifecycleStatus;
//
//    private TimePeriod validFor;




}
