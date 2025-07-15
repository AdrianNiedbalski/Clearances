package org.example.clearances.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CustomsRequest {
    private Integer id;
    private String customsType;
    private Integer exporterId;
    private String exporterName;
    private Integer importerId;
    private String importerName;
    private Integer employeeId;
    private String employeeName;
    private String transportLocation;
    private List<Integer> cargoIds;
    private Integer customsOfficeId;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    // --- Gettery i Settery ---

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomsType() {
        return customsType;
    }
    public void setCustomsType(String customsType) {
        this.customsType = customsType;
    }

    public Integer getExporterId() {
        return exporterId;
    }
    public void setExporterId(Integer exporterId) {
        this.exporterId = exporterId;
    }

    public String getExporterName() {
        return exporterName;
    }
    public void setExporterName(String exporterName) {
        this.exporterName = exporterName;
    }

    public Integer getImporterId() {
        return importerId;
    }
    public void setImporterId(Integer importerId) {
        this.importerId = importerId;
    }

    public String getImporterName() {
        return importerName;
    }
    public void setImporterName(String importerName) {
        this.importerName = importerName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTransportLocation() {
        return transportLocation;
    }
    public void setTransportLocation(String transportLocation) {
        this.transportLocation = transportLocation;
    }

    public List<Integer> getCargoIds() {
        return cargoIds;
    }
    public void setCargoIds(List<Integer> cargoIds) {
        this.cargoIds = cargoIds;
    }

    public Integer getCustomsOfficeId() {
        return customsOfficeId;
    }
    public void setCustomsOfficeId(Integer customsOfficeId) {
        this.customsOfficeId = customsOfficeId;
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
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}