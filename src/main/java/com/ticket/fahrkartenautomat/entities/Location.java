package com.ticket.fahrkartenautomat.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_sequence")
    @SequenceGenerator(name="location_sequence", sequenceName="location_sequence", allocationSize=100)
    private Long id;

    private float latitude;

    private float longitude;

    private static final long serialVersionUID = 1L;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public float getLatidude() {
        return latitude;
    }

    public void setLatidude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
}