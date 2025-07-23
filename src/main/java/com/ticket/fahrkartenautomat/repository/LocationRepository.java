package com.ticket.fahrkartenautomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.fahrkartenautomat.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Additional query methods can be defined here if needed
    // For example, to find locations by latitude and longitude:
    // List<Location> findByLatitudeAndLongitude(float latitude, float longitude);
}
