package com.smart_irrigation.rest.dtos;

import com.smart_irrigation.persistence.model.Plant;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlantDto {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public PlantDto() {
    }

    public PlantDto(Plant model) {
        this.id = model.getId();
    }

}
