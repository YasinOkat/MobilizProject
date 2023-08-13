package com.example.Mobiliz.dao;

import com.example.Mobiliz.model.VehicleAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleAuthorizationRepository extends JpaRepository<VehicleAuthorization, Long> {
    void deleteByUserIdAndVehicleId(Long userId, Long vehicleId);
}
