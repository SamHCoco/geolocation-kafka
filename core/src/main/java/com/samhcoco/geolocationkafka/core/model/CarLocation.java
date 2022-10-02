package com.samhcoco.geolocationkafka.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarLocation {
    private int carId;
    private float latitude;
    private float longitude;
}
