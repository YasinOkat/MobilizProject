package com.example.Mobiliz.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Mobiliz.model.VehicleGroup;
import com.example.Mobiliz.service.VehicleGroupService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-groups")
public class VehicleGroupController {

    private final VehicleGroupService vehicleGroupService;

    @Autowired
    public VehicleGroupController(VehicleGroupService vehicleGroupService) {
        this.vehicleGroupService = vehicleGroupService;
    }

    @GetMapping
    public List<VehicleGroup> getVehicleGroups() {
        return vehicleGroupService.getAllVehicleGroups();
    }

    @PostMapping
    public VehicleGroup createVehicleGroup(@RequestBody VehicleGroup vehicleGroup) {
        return vehicleGroupService.createVehicleGroup(vehicleGroup);
    }

    @GetMapping("/{id}")
    public VehicleGroup getVehicleGroupById(@PathVariable Long id) {
        return vehicleGroupService.getVehicleGroupById(id);
    }

    @PutMapping("/{id}")
    public VehicleGroup updateVehicleGroup(@PathVariable Long id, @RequestBody VehicleGroup vehicleGroup) {
        return vehicleGroupService.updateVehicleGroup(id, vehicleGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleGroup(@PathVariable Long id) {
        vehicleGroupService.deleteVehicleGroup(id);
    }
}
