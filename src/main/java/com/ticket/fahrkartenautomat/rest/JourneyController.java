package com.ticket.fahrkartenautomat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticket.fahrkartenautomat.entities.Journey;
import com.ticket.fahrkartenautomat.repository.JourneyRepository;

@RestController
@RequestMapping("/journeys")
public class JourneyController {

    @Autowired
    private JourneyRepository journeyRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Journey> getJourneyById(@PathVariable Long id) {
        return journeyRepository.findById(id)
                .map(journey -> ResponseEntity.ok(journey))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Journey> createJourney(@RequestBody Journey journey) {
        Journey savedJourney = journeyRepository.save(journey);
        return ResponseEntity.status(201).body(savedJourney);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journey> updateJourney(@PathVariable Long id, @RequestBody Journey journey) {
        return journeyRepository.findById(id)
                .map(existingJourney -> {
                    existingJourney.setStartStation(journey.getStartStation());
                    existingJourney.setEndStation(journey.getEndStation());
                    existingJourney.setStartTime(journey.getStartTime());
                    existingJourney.setEndTime(journey.getEndTime());
                    Journey updatedJourney = journeyRepository.save(existingJourney);
                    return ResponseEntity.ok(updatedJourney);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJourney(@PathVariable Long id) {
        return journeyRepository.findById(id)
                .map(journey -> {
                    journeyRepository.delete(journey);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Journey>> getAllJourneys() {
        Iterable<Journey> journeys = journeyRepository.findAll();
        return ResponseEntity.ok(journeys);
    }
    
}
