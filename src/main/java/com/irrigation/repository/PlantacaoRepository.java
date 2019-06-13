package com.irrigation.repository;

import com.irrigation.model.entity.Plantacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlantacaoRepository extends JpaRepository<Plantacao, Long> {
    Optional<Plantacao> findById(Long id);
}
