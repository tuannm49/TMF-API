package oda.api.tmf.commons.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Money implements java.io.Serializable {
    private String unit;
    private String value;
}
