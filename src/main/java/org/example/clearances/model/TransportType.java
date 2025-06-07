package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transport_types")
public class TransportType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_type_id")
    private Long id;

    @Column(name = "transport_type", nullable = false)
    private String transportType;

    public TransportType() {}

    public TransportType(String transportType) {
        this.transportType = transportType;
    }

    public Long getId() {
        return id;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
}
