package enhaunce.exceptionframework.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
public abstract class EnhaunceException extends RuntimeException {

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;
    private Instant timestamp;
    private String traceId;

}
