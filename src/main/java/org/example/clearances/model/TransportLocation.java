package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transport_location")
public class TransportLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_location_id")
    private Long id;

    @Column(name = "location_status", nullable = false)
    private String locationStatus;

    public TransportLocation() {}

    public TransportLocation(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public Long getId() {
        return id;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }
}
