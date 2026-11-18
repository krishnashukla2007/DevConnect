package com.devconnect.devconnect.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController                               //tells the springboot framework that take this class as a controller

public class HealthController {
    //URL GET /health
    @GetMapping("/health")
    public static String getHealth() {
        return "SpringBoot application running HEALTHY";
    }

    //URL GET /api/v1/status
    @GetMapping("/api/v1/status")
    public static Map<String, Object> getStatus() {
        Map<String, Object> map = new HashMap<>();

        map.put("Status", "Ok");
        map.put("Service", "DevConnect");
        map.put("Version", "1.0.0");
        map.put("timestamp", LocalDateTime.now().toString());

        return map;
    }


    //JACKSON - converts JAVA Objects to HTTP request compatible format
}