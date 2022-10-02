package com.samhcoco.geolocation.location.service.impl;

import com.samhcoco.geolocation.location.service.LocationService;
import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaLocationServiceImpl implements LocationService {

    @Override
    public CarLocation update(@NonNull CarLocation location) {
        return null;
    }
}
