package org.example.clearances.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cargos")
public class Cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "transport_type_id", nullable = false)
    private TransportType transportType;

    public Cargos() {}

    public Cargos(String name, BigDecimal weight, BigDecimal price, String invoiceNumber, TransportType transportType) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.invoiceNumber = invoiceNumber;
        this.transportType = transportType;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getWeight() { return weight; }
    public BigDecimal getPrice() { return price; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public TransportType getTransportType() { return transportType; }

    public void setName(String name) { this.name = name; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setTransportType(TransportType transportType) { this.transportType = transportType; }
}
