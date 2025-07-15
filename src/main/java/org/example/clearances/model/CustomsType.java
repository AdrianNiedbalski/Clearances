package org.example.clearances.model;

public enum CustomsType {
    EXPORT("Export"),
    IMPORT("Import"),
    TRANSIT("Tranzyt");

    private final String displayName;

    CustomsType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
