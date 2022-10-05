package com.samhcoco.geolocationkafka.tracker.listeners;

import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.samhcoco.geolocationkafka.core.constants.KafkaConstants.CAR_LOCATION_TOPIC;

@Slf4j
@Component
public class CarLocationListener {

    @KafkaListener(
            topics = CAR_LOCATION_TOPIC,
            containerFactory = "carLocationListenerFactory",
            groupId = "car-location-group-1"
    )
    public void carLocationListener(CarLocation carLocation) {
        log.info("Message received from '{}' topic: {}", CAR_LOCATION_TOPIC, carLocation);
    }

}
