package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Date;

@Embeddable
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimePeriod implements java.io.Serializable {
    private Date startDateTime;
    private Date endDateTime;
    @JsonIgnore
    public boolean isEmpty() {
        return startDateTime == null && endDateTime == null;
    }

    @JsonIgnore
    public boolean isValid() {
        return true;
    }
}
