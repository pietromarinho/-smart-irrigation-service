package com.irrigation.model.enumerations;

public enum PlantGroup {
    CRIPTOGAMA("CRIPTOGAMA"), FANEROGAMA("FANEROGAMA");

    private String value;

    PlantGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
