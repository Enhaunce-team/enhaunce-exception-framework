package enhaunce.exceptionframework.dto;

import lombok.Builder;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;


@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnhaunceExceptionResponse implements Serializable {

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
    private final Map<String, Object> properties;
    private Instant timestamp;
    private String traceId;

    public void addErrorProperties(Map<String, Object> errorProperties) {
        properties.putAll(errorProperties);
    }

    public void addErrorProperty(String propertyName, Object propertyValue) {
        properties.put(propertyName, propertyValue);
    }


}
