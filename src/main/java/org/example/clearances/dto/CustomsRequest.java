package org.example.clearances.dto;

import org.example.clearances.model.CustomsStatus;

public class CustomsRequest {
    private Long exporterId;
    private Long importerId;
    private Long agentId;
    private Long customsTypeId;
    private Long transportLocationId;
    private Long cargosId;
    private Long customsOfficeId;
    private CustomsStatus status;

    public Long getExporterId() { return exporterId; }
    public void setExporterId(Long exporterId) { this.exporterId = exporterId; }

    public Long getImporterId() { return importerId; }
    public void setImporterId(Long importerId) { this.importerId = importerId; }

    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }

    public Long getCustomsTypeId() { return customsTypeId; }
    public void setCustomsTypeId(Long customsTypeId) { this.customsTypeId = customsTypeId; }

    public Long getTransportLocationId() { return transportLocationId; }
    public void setTransportLocationId(Long transportLocationId) { this.transportLocationId = transportLocationId; }

    public Long getCargosId() { return cargosId; }
    public void setCargosId(Long cargosId) { this.cargosId = cargosId; }

    public Long getCustomsOfficeId() { return customsOfficeId; }
    public void setCustomsOfficeId(Long customsOfficeId) { this.customsOfficeId = customsOfficeId; }

    public CustomsStatus getStatus() { return status; }
    public void setStatus(CustomsStatus status) { this.status = status; }
}
