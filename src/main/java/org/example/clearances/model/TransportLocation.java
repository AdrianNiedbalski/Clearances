package org.example.clearances.model;

public enum TransportLocation {
    W_DRODZE("W drodze"),
    W_URZEDZIE("W urzędzie"),
    KURIER("Kurier");

    private final String displayName;

    TransportLocation(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
