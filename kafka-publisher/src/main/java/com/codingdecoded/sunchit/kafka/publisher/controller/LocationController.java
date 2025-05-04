
package com.codingdecoded.sunchit.kafka.publisher.controller;

import com.codingdecoded.sunchit.kafka.publisher.model.DriverLocation;
import com.codingdecoded.sunchit.kafka.publisher.service.LocationPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationPublisherService locationPublisherService;

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestBody DriverLocation location) {
        locationPublisherService.publishLocation(location);
        return "Location update published successfully.";
    }
}
