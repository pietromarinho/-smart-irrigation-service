package com.irrigation.rest.service;

import com.irrigation.exception.BOException;
import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.model.entity.Plantacao;
import com.irrigation.repository.PlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class PlantacaoService {
    @Autowired
    private PlantacaoRepository repository;

    public PlantacaoDTO save(PlantacaoDTO dto) {
        Plantacao model = new Plantacao(dto);
        LocalDateTime act = LocalDateTime.now().plusMinutes(dto.getInterval());
        model.setActivationTime(act);

        return new PlantacaoDTO(this.repository.save(model));
    }

    public PlantacaoDTO findOne(Long id) {
        Optional<Plantacao> model = this.repository.findById(id);

        if (!model.isPresent()) {
            throw new BOException("plantação inexistente.", new Throwable("plantacao.notfound"));
        }

        return new PlantacaoDTO(model.get());
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
