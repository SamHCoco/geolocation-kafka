package com.samhcoco.geolocationkafka.core.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionMessage {
    private HttpStatus status;
    private String message;
    private ZonedDateTime timestamp;
}
