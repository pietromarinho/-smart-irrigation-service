package com.irrigation.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irrigation.model.entity.Plant;
import com.irrigation.model.entity.Plantacao;
import com.irrigation.model.enumerations.PlantGroup;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PlantacaoDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    @NotNull(message = "Plantas não pode estar vazio.")
    private List<PlantDTO> plants;

    @NotNull(message = "interval")
    private Long interval;

    public PlantacaoDTO() {
    }

    public PlantacaoDTO(Plantacao model) {
        this.id = model.getId();
        this.name = model.getName();
        this.interval = model.getInterval();
        this.plants = model.getPlants().stream().map(plant -> new PlantDTO(plant)).collect(Collectors.toList());
    }
}
