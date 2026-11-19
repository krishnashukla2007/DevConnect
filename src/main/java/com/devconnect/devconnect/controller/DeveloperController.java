package com.devconnect.devconnect.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devconnect.devconnect.model.Developer;



@RestController
@RequestMapping("/api/v1/developers")            //common class path for this controller

public class DeveloperController {
    //In Memory Storage
    //Concurrent HashMap - safe for concurrent requests
    private final Map<Long, Developer> developers = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping("")                                     // it can be even written as @GetMapping
    public List<Developer> getDevelopers() {
        return new ArrayList<>(developers.values());
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable Long id) {
        return developers.get(id);
    }

    @GetMapping("/search")
    public List<Developer> getDeveloperBySkill(
        @RequestParam String skill,
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue="0") int count
    ) {
        List<Developer> developersWithSkills = new ArrayList<>();
        
        for(Developer developer: developers.values()) {
            if(developer.getSkills().contains(skill)) {
                developersWithSkills.add(developer);
            }
        }

        return developersWithSkills;
    }

    //@PostMapping
    //public Developer addDeveloper(@RequestBody Developer developer) {
    //    developer.setId(idCounter.getAndIncrement());
    //    developers.put(developer.getId(), developer);
    //    
    //   return developer;
    //}
    
    //used when we want to put our own status code
    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        developer.setId(idCounter.getAndIncrement());
        developers.put(developer.getId(), developer);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}