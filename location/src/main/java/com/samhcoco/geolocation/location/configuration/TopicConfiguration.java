package com.samhcoco.geolocation.location.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.samhcoco.geolocationkafka.core.constants.KafkaConstants.CAR_LOCATION_TOPIC;

@Configuration
public class TopicConfiguration {

    @Value("${application.cars.total}")
    private int numberOfCars;

    @Bean
    public NewTopic carLocationTopic() {
        return TopicBuilder.name(CAR_LOCATION_TOPIC)
                           .partitions(numberOfCars)
                           //.replicas(3)
                           .build();
    }

}
