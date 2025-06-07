package org.example.clearances.dto;

public class CargosRequest {
    private String name;
    private String invoiceNumber;
    private Double weight;
    private Double price;
    private Long transportTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(Long transportTypeId) {
        this.transportTypeId = transportTypeId;
    }
}
