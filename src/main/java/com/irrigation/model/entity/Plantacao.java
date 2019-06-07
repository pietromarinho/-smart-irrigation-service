package com.irrigation.model.entity;

import com.irrigation.model.dto.PlantDTO;
import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.model.enumerations.PlantGroup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "plantacao")
public class Plantacao extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    @ManyToMany()
    private List<Plant> plants;

    @Enumerated(EnumType.STRING)
    private PlantGroup plantGroup;

    public Plantacao() {
    }

    public Plantacao(PlantacaoDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setPlants(dto.getPlants().stream().map(plant -> new Plant(plant)).collect(Collectors.toList()));

    }
}
