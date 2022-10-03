package com.samhcoco.geolocation.location.configuration;

import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.val;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServerUrl;

    /**
     * Defines the required configurations for the Kafka producer.
     * @return Producer configurations.
     */
    public Map<String, Object> producerConfiguration() {
        val props = new HashMap<String, Object>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerUrl);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    /**
     * Returns a producer factory with the configurations defined above.
     * @return Kafka {@link ProducerFactory}.
     */
    @Bean
    public ProducerFactory<String, CarLocation> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfiguration());
    }

    /**
     * Returns the {@link KafkaTemplate} bean which wraps the producer factory
     * is used to send messages to the broker.
     * @return {@link KafkaTemplate}.
     */
    @Bean
    public KafkaTemplate<String, CarLocation> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
