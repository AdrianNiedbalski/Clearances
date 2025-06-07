package org.example.clearances.model;

public enum CustomsTypeEnum {
    EXPORT("Export"),
    IMPORT("Import"),
    TRANSIT("Tranzyt");

    private final String displayName;

    CustomsTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
