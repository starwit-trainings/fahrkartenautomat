package com.ticket.fahrkartenautomat.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "journey")
public class Journey implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="journey_sequence")
    @SequenceGenerator(name="journey_sequence", sequenceName="journey_sequence", allocationSize=100)
    private Long id;

    private Station startStation;

    private Station endStation;
    
    private String startTime;

    private String endTime;

    private static final long serialVersionUID = 1L;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}