package com.samhcoco.geolocation.location.service;

import com.samhcoco.geolocationkafka.core.model.CarLocation;

public interface LocationService {

    /**
     * Updates {@link CarLocation}.
     * @param location {@link CarLocation}.
     * @return Updated {@link CarLocation}.
     */
    CarLocation update(CarLocation location);

}
