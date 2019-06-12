package com.irrigation.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irrigation.model.entity.Plantacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @NotNull(message = "blabla")
    @JsonProperty("interval")
    private int interval;

    private LocalDateTime activationTime;

    @JsonProperty("ip")
    private String ip;

    public PlantacaoDTO() {
    }

    public PlantacaoDTO(Plantacao model) {
        this.id = model.getId();
        this.name = model.getName();
        this.interval = model.getInterval();
        this.activationTime = model.getActivationTime();
        this.id = model.getId();
        this.plants = model.getPlants().stream().map(plant -> new PlantDTO(plant)).collect(Collectors.toList());
    }
}
