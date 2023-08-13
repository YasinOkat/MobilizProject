package com.example.Mobiliz.ServiceImpl;

import com.example.Mobiliz.dao.VehicleGroupRepository;
import com.example.Mobiliz.model.VehicleGroup;
import com.example.Mobiliz.service.VehicleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleGroupServiceImpl implements VehicleGroupService {

    private final VehicleGroupRepository vehicleGroupRepository;

    @Autowired
    public VehicleGroupServiceImpl(VehicleGroupRepository vehicleGroupRepository) {
        this.vehicleGroupRepository = vehicleGroupRepository;
    }

    @Override
    public List<VehicleGroup> getAllVehicleGroups() {
        return vehicleGroupRepository.findAll();
    }

    @Override
    public VehicleGroup getVehicleGroupById(Long groupId) {
        return vehicleGroupRepository.findById(groupId).orElse(null);
    }

    @Override
    public VehicleGroup createVehicleGroup(VehicleGroup vehicleGroup) {
        return vehicleGroupRepository.save(vehicleGroup);
    }

    @Override
    public VehicleGroup updateVehicleGroup(Long groupId, VehicleGroup vehicleGroup) {
        if (vehicleGroupRepository.existsById(groupId)) {
            vehicleGroup.setId(groupId);
            return vehicleGroupRepository.save(vehicleGroup);
        }
        return null;
    }

    @Override
    public void deleteVehicleGroup(Long groupId) {
        vehicleGroupRepository.deleteById(groupId);
    }

}
