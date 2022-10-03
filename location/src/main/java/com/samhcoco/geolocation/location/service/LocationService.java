package com.samhcoco.geolocation.location.service;

import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.NonNull;
import lombok.val;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public interface LocationService {

    /**
     * Updates {@link CarLocation}.
     * @param location {@link CarLocation}.
     */
    void update(CarLocation location);

    /**
     * Validates an update for {@link CarLocation}.
     * @param location {@link CarLocation}.
     * @return Validation result.
     */
    default Map<String, String> validateUpdate(@NonNull CarLocation location) {
        val errors = new HashMap<String, String>();

        val carId = location.getCarId();
        if (isNull(carId) || carId == 0) {
            errors.put("carId", "Car ID is invalid.");
        }

        val latitude = location.getLatitude();
        if (!(latitude >= -90.0 && latitude <= 90.0)) {
            errors.put("latitude", format("Latitude '%s' is invalid.", latitude));
        }

        val longitude = location.getLongitude();
        if (!(longitude >= -180.0 && longitude <= 180.0)) {
            errors.put("longitude", format("Longitude '%s' is invalid.", latitude));
        }

        return errors;
    }

}
