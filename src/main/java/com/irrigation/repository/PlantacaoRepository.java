package com.irrigation.repository;

import com.irrigation.model.entity.Plant;
import com.irrigation.model.entity.Plantacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantacaoRepository extends JpaRepository<Plantacao, Long> {
}
