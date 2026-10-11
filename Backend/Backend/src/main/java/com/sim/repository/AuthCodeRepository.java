package com.sim.repository;
import com.sim.model.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
    Optional<AuthCode> findByTargetUsernameAndTypeAndUsedAtIsNull(String targetUsername, String type);
}