package com.example.Mobiliz.service;

import com.example.Mobiliz.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long vehicleId);

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);

    void deleteVehicle(Long vehicleId);

}
