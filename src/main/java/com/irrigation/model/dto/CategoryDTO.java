package com.irrigation.model.dto;

import com.irrigation.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
