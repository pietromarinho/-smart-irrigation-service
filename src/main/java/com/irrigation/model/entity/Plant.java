package com.irrigation.model.entity;

import com.irrigation.model.dto.PlantDTO;
import com.irrigation.model.enumerations.PlantGroup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "plant")
public class Plant extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_category"))
    private Category category;

    @Enumerated(EnumType.STRING)
    private PlantGroup plantGroup;

    public Plant() {
    }

    public Plant(PlantDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setCategory(new Category(dto.getCategory()));
        setPlantGroup(dto.getPlantGroup());
    }
}
