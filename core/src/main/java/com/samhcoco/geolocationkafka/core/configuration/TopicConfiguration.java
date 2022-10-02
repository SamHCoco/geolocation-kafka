package com.samhcoco.geolocationkafka.core.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic carLocationTopic() {
        return TopicBuilder.name("car-location")
                           .partitions(5)
                           .replicas(3)
                           .build();
    }

}
