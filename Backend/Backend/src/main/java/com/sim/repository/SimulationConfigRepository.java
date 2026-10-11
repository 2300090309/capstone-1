package com.sim.repository;

import com.sim.model.SimulationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulationConfigRepository extends JpaRepository<SimulationConfig, String> {
    List<SimulationConfig> findByConsensusType(String consensusType);
    List<SimulationConfig> findByNetworkTopology(String networkTopology);
    List<SimulationConfig> findByConsensusTypeAndNetworkTopology(String consensusType, String networkTopology);
}
