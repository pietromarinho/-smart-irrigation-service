package com.irrigation.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irrigation.model.entity.Plant;
import com.irrigation.model.enumerations.PlantGroup;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlantDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    @NotNull(message = "Categoria não pode estar vazio.")
    private CategoryDTO category;

    @JsonProperty("plant_type")
    private PlantGroup plantGroup;

    public PlantDTO() {
    }

    public PlantDTO(Plant model) {
        this.id = model.getId();
        this.name = model.getName();
        this.category = new CategoryDTO(model.getCategory());
        this.plantGroup = model.getPlantGroup();
    }
}
