package com.example.Mobiliz.service;

import com.example.Mobiliz.model.VehicleGroup;

import java.util.List;

public interface VehicleGroupService {

    List<VehicleGroup> getAllVehicleGroups();

    VehicleGroup getVehicleGroupById(Long groupId);

    VehicleGroup createVehicleGroup(VehicleGroup vehicleGroup);

    VehicleGroup updateVehicleGroup(Long groupId, VehicleGroup vehicleGroup);

    void deleteVehicleGroup(Long groupId);

}
