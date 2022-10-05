package com.samhcoco.geolocation.location.controller;

import com.google.gson.Gson;
import com.samhcoco.geolocation.location.service.impl.KafkaLocationServiceImpl;
import com.samhcoco.geolocationkafka.core.exceptions.InvalidInputException;
import com.samhcoco.geolocationkafka.core.model.CarLocation;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private static final String VERSION = "api/v1";

    private final KafkaLocationServiceImpl locationService;
    private final Gson gson;

    @PostMapping(VERSION + "/location")
    public ResponseEntity<String> update(@RequestBody CarLocation carLocation) {
        val errors = locationService.validateUpdate(carLocation);
        if (errors.size() > 0) {
            throw new InvalidInputException(gson.toJson(errors));
        }
        locationService.update(carLocation);
        return new ResponseEntity<>(gson.toJson(carLocation), OK);
    }

}
