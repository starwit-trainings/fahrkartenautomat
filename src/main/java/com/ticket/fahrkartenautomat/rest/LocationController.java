package com.ticket.fahrkartenautomat.rest;

import com.ticket.fahrkartenautomat.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticket.fahrkartenautomat.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationController {
    
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id)
                .map(location -> ResponseEntity.ok(location))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location savedLocation = locationRepository.save(location);
        return ResponseEntity.status(201).body(savedLocation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return locationRepository.findById(id)
                .map(existingLocation -> {
                    existingLocation.setLatidude(location.getLatidude());
                    existingLocation.setLongitude(location.getLongitude());
                    Location updatedLocation = locationRepository.save(existingLocation);
                    return ResponseEntity.ok(updatedLocation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable Long id) {
        return locationRepository.findById(id)
                .map(location -> {
                    locationRepository.delete(location);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Location>> getAllLocations() {
        Iterable<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }
}
