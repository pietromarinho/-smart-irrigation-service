package com.irrigation.rest.service;

import com.irrigation.exception.BOException;
import com.irrigation.model.dto.PlantDTO;
import com.irrigation.model.entity.Plant;
import com.irrigation.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PlantService {
    @Autowired
    private PlantRepository repository;

    public PlantDTO save(PlantDTO dto) {
        Plant model = new Plant(dto);

        return new PlantDTO(this.repository.save(model));
    }

    public PlantDTO findOne(Long id) {
        Plant model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("planta inexistente.", new Throwable("vehicle.notfound"));
        }

        return new PlantDTO(model);
    }

    public Collection<PlantDTO> findAll() {
        Collection<Plant> plants = this.repository.findAll();
        Collection<PlantDTO> plantsDto = new ArrayList<>();

        plants.forEach((item) -> {
            plantsDto.add(new PlantDTO(item));
        });

        return plantsDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
