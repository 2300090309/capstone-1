package com.sim.repository;

import com.sim.model.SimulationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulationResultRepository extends JpaRepository<SimulationResult, String> {
    List<SimulationResult> findByConfigId(String configId);
}
