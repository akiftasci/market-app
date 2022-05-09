package com.ing.appleMarket.exception;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ApiException {
    private final String message;
    private HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(final String message,
                        final HttpStatus status,
                        final ZonedDateTime timestamp) {
        this.message = message;
        httpStatus = status;
        this.timestamp = timestamp;
    }
}
