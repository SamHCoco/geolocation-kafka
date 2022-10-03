package com.samhcoco.geolocationkafka.core.controller;

import com.samhcoco.geolocationkafka.core.exceptions.ExceptionMessage;
import com.samhcoco.geolocationkafka.core.exceptions.InvalidInputException;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {InvalidInputException.class})
    public ResponseEntity<ExceptionMessage> handleInvalidInputException(InvalidInputException ex) {
        val error = ExceptionMessage.builder()
                                    .message(ex.getMessage())
                                    .status(BAD_REQUEST)
                                    .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                                    .build();
        return new ResponseEntity<ExceptionMessage>(error, BAD_REQUEST);
    }

}
