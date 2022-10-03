package com.samhcoco.geolocationkafka.core.configuration;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
