package org.example.clearances.model;

public enum TransportTypeEnum {
    KURIER("kurier"),
    KONTENER("kontener"),
    SAMOLOT("samolot"),
    TIR("tir");

    private final String displayName;

    TransportTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static TransportTypeEnum fromString(String text) {
        for (TransportTypeEnum type : values()) {
            if (type.displayName.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Nieprawidłowy typ transportu: " + text);
    }
}
