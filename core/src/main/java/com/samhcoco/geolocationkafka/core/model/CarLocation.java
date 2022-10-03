package com.samhcoco.geolocationkafka.core.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarLocation {
    private Integer carId;
    private float latitude;
    private float longitude;
}
