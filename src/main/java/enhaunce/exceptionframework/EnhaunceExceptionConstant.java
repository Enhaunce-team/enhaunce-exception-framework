package enhaunce.exceptionframework;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public enum EnhaunceExceptionConstant {
    UNHANDLED_EXCEPTION("UNHANDLED_EXCEPTION", HttpStatus.BAD_REQUEST, "Unhandled exception occurred.");
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    EnhaunceExceptionConstant(String errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String toString() {
        return "EnhaunceExceptionConstant{" +
                "httpStatus=" + httpStatus +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
