package org.example.clearances.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customs_types")
public class CustomsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customs_type_id")
    private Long id;

    @Column(name = "customs_type", nullable = false)
    private String customsType;

    public Long getId() {
        return id;
    }

    public String getCustomsType() {
        return customsType;
    }

    public void setCustomsType(String customsType) {
        this.customsType = customsType;
    }
}
