package com.ticket.fahrkartenautomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.fahrkartenautomat.entities.Journey;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

}
