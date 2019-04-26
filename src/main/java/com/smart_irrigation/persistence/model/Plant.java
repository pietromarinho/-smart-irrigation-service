package com.smart_irrigation.persistence.model;

import com.smart_irrigation.persistence.model.base.BaseModel;
import com.smart_irrigation.rest.dtos.PlantDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "plant")
public class Plant extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    public Plant() {
    }

    public Plant(PlantDto dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
    }

}
