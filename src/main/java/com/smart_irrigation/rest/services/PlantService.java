package com.smart_irrigation.rest.services;

import com.smart_irrigation.exception.BOException;
import com.smart_irrigation.persistence.model.Plant;
import com.smart_irrigation.persistence.repositories.PlantRepository;
import com.smart_irrigation.rest.dtos.PlantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PlantService {

    @Autowired
    private PlantRepository repository;

    public PlantDto save(PlantDto dto) {
        Plant model = new Plant(dto);

        return new PlantDto(this.repository.save(model));
    }

    public PlantDto findOne(Long id) {
        Plant model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("Veículo inexistente.", new Throwable("vehicle.notfound"));
        }

        return new PlantDto(model);
    }

    public Collection<PlantDto> findAll() {
        Collection<Plant> plants = this.repository.findAll();
        Collection<PlantDto> plantsDto = new ArrayList<>();

        plants.forEach((item) -> {
            plantsDto.add(new PlantDto(item));
        });

        return plantsDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }

}