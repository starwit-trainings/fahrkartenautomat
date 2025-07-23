package com.ticket.fahrkartenautomat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticket.fahrkartenautomat.entities.Station;
import com.ticket.fahrkartenautomat.repository.StationRepository;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        return stationRepository.findById(id)
                .map(station -> ResponseEntity.ok(station))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        Station savedStation = stationRepository.save(station);
        return ResponseEntity.status(201).body(savedStation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Station> updateStation(@PathVariable Long id, @RequestBody Station station) {
        return stationRepository.findById(id)
                .map(existingStation -> {
                    existingStation.setName(station.getName());
                    existingStation.setLocation(station.getLocation());
                    Station updatedStation = stationRepository.save(existingStation);
                    return ResponseEntity.ok(updatedStation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStation(@PathVariable Long id) {
        return stationRepository.findById(id)
                .map(station -> {
                    stationRepository.delete(station);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Station>> getAllStations() {
        Iterable<Station> stations = stationRepository.findAll();
        return ResponseEntity.ok(stations);
    }
}
