package com.samhcoco.geolocation.location.service.impl;

import com.samhcoco.geolocation.location.service.LocationService;
import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static com.samhcoco.geolocationkafka.core.constants.KafkaConstants.CAR_LOCATION_TOPIC;
import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaLocationServiceImpl implements LocationService {

    private final KafkaTemplate<String, CarLocation> kafkaTemplate;

    @Override
    public void update(@NonNull CarLocation carLocation) {
        val partitionKey = format("%s-%s", CAR_LOCATION_TOPIC, carLocation.getCarId() - 1);

        val resultFuture = kafkaTemplate.send(CAR_LOCATION_TOPIC, partitionKey, carLocation);

        resultFuture.addCallback(new ListenableFutureCallback<SendResult<String, CarLocation>>() {
            @Override
            public void onSuccess(SendResult<String, CarLocation> result) {
                log.info("Successfully sent message {} to topic '{}' for Car ID '{}'",
                         carLocation, CAR_LOCATION_TOPIC, carLocation.getCarId());
                // send notification to client device in car
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Failed to send message {} to topic '{}' for Car ID '{}' - " +
                          "reason: {}", carLocation, CAR_LOCATION_TOPIC, carLocation.getCarId(), ex.getMessage());
                // send error notification to client device in car
            }
        });
    }

}
