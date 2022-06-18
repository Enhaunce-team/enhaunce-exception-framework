package enhaunce.exceptionframework.advices;
import enhaunce.exceptionframework.EnhaunceExceptionConstant;
import enhaunce.exceptionframework.dto.EnhaunceExceptionResponse;
import enhaunce.exceptionframework.exceptions.EnhaunceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
public class EnhaunceExceptionAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnhaunceExceptionAdvice.class);

    @ExceptionHandler(EnhaunceException.class)
    public ResponseEntity<EnhaunceExceptionResponse> handleEnhauceException(EnhaunceException exception) {
        EnhaunceExceptionResponse response =
                EnhaunceExceptionResponse.builder()
                        .timestamp(Instant.now())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .message(exception.getMessage())
                        .errorCode(EnhaunceExceptionConstant.UNHANDLED_EXCEPTION.getErrorCode())
                        .traceId("TRACE_ID")
                        .build();
        writeLog(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EnhaunceExceptionResponse> unhandleException(Exception exception) {
        EnhaunceExceptionResponse response =
                EnhaunceExceptionResponse.builder()
                        .timestamp(Instant.now())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .message(exception.getMessage())
                        .errorCode(EnhaunceExceptionConstant.UNHANDLED_EXCEPTION.getErrorCode())
                        .traceId("TRACE_ID")
                        .build();
        writeLog(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private ResponseEntity<EnhaunceExceptionResponse> buildEnhaunceExceptionResponse(EnhaunceException exception) {
        EnhaunceExceptionResponse response =
                EnhaunceExceptionResponse.builder()
                        .timestamp(Instant.now())
                        .message(exception.getMessage())
                        .errorCode(exception.getErrorCode())
//                        .traceId(MDC.get(ImExceptionFrameworkConstant.TRACE_ID))
                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private final void writeLog(EnhaunceExceptionResponse exception) {
        LOGGER.error("Enhaunce exception with httpStatus {}, errorCode {}, message {}, traceId {} at {}",
                exception.getHttpStatus(),
                exception.getErrorCode(),
                exception.getMessage(),
                exception.getTraceId(),
                exception.getTimestamp());
    }
}
