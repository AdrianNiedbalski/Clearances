package org.example.clearances.model;

public enum TransportType {
    DROGOWY("Samochód"),
    KOLEJOWY("Kolej"),
    MORSKI("Statek"),
    LOTNICZY("Samolot");

    private final String label;
    TransportType(String label) { this.label = label; }
    public String getLabel() { return label; }
}
