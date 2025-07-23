package com.ticket.fahrkartenautomat.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "station")
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="station_sequence")
    @SequenceGenerator(name="station_sequence", sequenceName="station_sequence", allocationSize=100)
    private Long id;
    
    private String name;

    private Location location;

    public static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}