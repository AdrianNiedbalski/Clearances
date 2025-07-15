package org.example.clearances.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customs")
public class Customs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customs_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exporter_id", nullable = false)
    private Client exporter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "importer_id", nullable = false)
    private Client importer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "customs_type", nullable = false, length = 50)
    private String customsType;

    @Column(name = "transport_location", nullable = false, length = 50)
    private String transportLocation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "customs_cargos",
            joinColumns = @JoinColumn(name = "customs_id"),
            inverseJoinColumns = @JoinColumn(name = "cargo_id")
    )
    private Set<Cargo> cargos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customs_office_id", nullable = false)
    private CustomsOffice customsOffice;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    public Customs() {}

    // --- Gettery i settery ---

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Client getExporter() {
        return exporter;
    }
    public void setExporter(Client exporter) {
        this.exporter = exporter;
    }

    public Client getImporter() {
        return importer;
    }
    public void setImporter(Client importer) {
        this.importer = importer;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCustomsType() {
        return customsType;
    }
    public void setCustomsType(String customsType) {
        this.customsType = customsType;
    }

    public String getTransportLocation() {
        return transportLocation;
    }
    public void setTransportLocation(String transportLocation) {
        this.transportLocation = transportLocation;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }
    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

    public CustomsOffice getCustomsOffice() {
        return customsOffice;
    }
    public void setCustomsOffice(CustomsOffice customsOffice) {
        this.customsOffice = customsOffice;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
