package org.example.clearances.model;
import org.example.clearances.model.Agent;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customs")
public class Customs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customs_type_id", nullable = false)
    private CustomsType customsType;

    @ManyToOne
    @JoinColumn(name = "exporter_id", nullable = false)
    private Person exporter;

    @ManyToOne
    @JoinColumn(name = "importer_id", nullable = false)
    private Person importer;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent; // ✅ Agent z właściwego pakietu

    @ManyToOne
    @JoinColumn(name = "transport_location_id", nullable = false)
    private TransportLocation transportLocation;

    @ManyToOne
    @JoinColumn(name = "cargos_id", nullable = false)
    private Cargos cargos;

    @ManyToOne
    @JoinColumn(name = "customs_office_id", nullable = false)
    private CustomsOffice customsOffice;

    @Enumerated(EnumType.STRING)
    private CustomsStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // --- Gettery i Settery ---

    public Long getId() { return id; }

    public CustomsType getCustomsType() { return customsType; }
    public void setCustomsType(CustomsType customsType) { this.customsType = customsType; }

    public Person getExporter() { return exporter; }
    public void setExporter(Person exporter) { this.exporter = exporter; }

    public Person getImporter() { return importer; }
    public void setImporter(Person importer) { this.importer = importer; }

    public Agent getAgent() { return agent; }
    public void setAgent(Agent agent) { this.agent = agent; }

    public TransportLocation getTransportLocation() { return transportLocation; }
    public void setTransportLocation(TransportLocation transportLocation) { this.transportLocation = transportLocation; }

    public Cargos getCargos() { return cargos; }
    public void setCargos(Cargos cargos) { this.cargos = cargos; }

    public CustomsOffice getCustomsOffice() { return customsOffice; }
    public void setCustomsOffice(CustomsOffice customsOffice) { this.customsOffice = customsOffice; }

    public CustomsStatus getStatus() { return status; }
    public void setStatus(CustomsStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}
