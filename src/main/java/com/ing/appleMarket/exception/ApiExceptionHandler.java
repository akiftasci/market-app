package com.ing.appleMarket.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class})
    public ResponseEntity<Object> handleApiRequestException(ConstraintViolationException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final String message = StringUtils.substringBetween(e.getMessage(), "'", "'");
        ApiException apiException = new ApiException(
            message,
            HttpStatus.BAD_REQUEST,
            ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }
}
