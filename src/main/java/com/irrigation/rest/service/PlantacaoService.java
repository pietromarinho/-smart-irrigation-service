package com.irrigation.rest.service;

import com.irrigation.exception.BOException;
import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.model.entity.Category;
import com.irrigation.model.entity.Plant;
import com.irrigation.model.entity.Plantacao;
import com.irrigation.repository.CategoryRepository;
import com.irrigation.repository.PlantRepository;
import com.irrigation.repository.PlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PlantacaoService {
    @Autowired
    private PlantacaoRepository repository;

    public PlantacaoDTO save(PlantacaoDTO dto) {
        Plantacao model = new Plantacao(dto);

        return new PlantacaoDTO(this.repository.save(model));
    }

    public PlantacaoDTO findOne(Long id) {
        Plantacao model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("plantcao inexistente.", new Throwable("vehicle.notfound"));
        }

        return new PlantacaoDTO(model);
    }

    public Collection<PlantacaoDTO> findAll() {
        Collection<Plantacao> plants = this.repository.findAll();
        Collection<PlantacaoDTO> plantsDto = new ArrayList<>();

        plants.forEach((item) -> {
            plantsDto.add(new PlantacaoDTO(item));
        });

        return plantsDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
