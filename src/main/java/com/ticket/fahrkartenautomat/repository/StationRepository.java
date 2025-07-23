package com.ticket.fahrkartenautomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.fahrkartenautomat.entities.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    // Additional query methods can be defined here if needed
    Station findByName(String name);    

}
