package org.example.clearances.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomsStatus {
    DO_PRZYGOTOWANIA("Do przygotowania"),
    W_REALIZACJI("W realizacji"),
    ZREALIZOWANE("ZREALIZOWANE");

    private final String value;

    CustomsStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CustomsStatus fromString(String text) {
        for (CustomsStatus status : values()) {
            if (status.value.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Nieznany status: " + text);
    }
}
