package com.irrigation.model.dto;

import com.irrigation.model.entity.Plant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlantDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public PlantDTO() {
    }

    public PlantDTO(Plant model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
