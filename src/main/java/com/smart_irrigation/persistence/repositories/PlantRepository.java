package com.smart_irrigation.persistence.repositories;

import com.smart_irrigation.persistence.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long>{
}
