package com.irrigation.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArduinoDTO {

    @NotNull(message = "IP não pode estar vazio.")
    private String ip;

    private Boolean ativar;

    public ArduinoDTO() {
    }
}
