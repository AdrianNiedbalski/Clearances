package org.example.clearances.model;

public enum CustomsStatus {
    DO_PRZYGOTOWANIA("Do przygotowania"),
    W_REALIZACJI("W realizacji"),
    ZREALIZOWANE("Zrealizowane");

    private final String displayName;

    CustomsStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
