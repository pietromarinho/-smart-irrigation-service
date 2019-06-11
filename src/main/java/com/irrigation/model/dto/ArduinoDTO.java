package com.irrigation.model.dto;

import com.irrigation.model.entity.Plantacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ArduinoDTO {

    @NotNull(message = "IP não pode estar vazio.")
    private String ip;

    private Boolean ativar;

    public ArduinoDTO() {
    }
}
