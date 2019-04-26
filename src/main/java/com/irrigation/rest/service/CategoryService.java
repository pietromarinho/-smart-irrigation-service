package com.irrigation.rest.service;

import com.irrigation.exception.BOException;
import com.irrigation.model.dto.CategoryDTO;
import com.irrigation.model.entity.Category;
import com.irrigation.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public CategoryDTO save(CategoryDTO dto) {
        Category model = new Category(dto);

        return new CategoryDTO(this.repository.save(model));
    }

    public CategoryDTO findOne(Long id) {
        Category model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("categoria inexistente.", new Throwable("vehicle.notfound"));
        }

        return new CategoryDTO(model);
    }

    public Collection<CategoryDTO> findAll() {
        Collection<Category> categories = this.repository.findAll();
        Collection<CategoryDTO> categoriesDto = new ArrayList<>();

        categories.forEach((item) -> {
            categoriesDto.add(new CategoryDTO(item));
        });

        return categoriesDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
