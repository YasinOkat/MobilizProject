package com.example.Mobiliz.dao;

import com.example.Mobiliz.model.VehicleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleGroupRepository extends JpaRepository<VehicleGroup, Long> {

}
