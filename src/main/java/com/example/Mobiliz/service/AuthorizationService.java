package com.example.Mobiliz.service;

import com.example.Mobiliz.dao.VehicleAuthorizationRepository;
import com.example.Mobiliz.dao.VehicleGroupMembershipRepository;
import com.example.Mobiliz.model.User;
import com.example.Mobiliz.model.VehicleAuthorization;
import com.example.Mobiliz.model.VehicleGroupMembership;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final VehicleAuthorizationRepository vehicleAuthorizationRepository;
    private final VehicleGroupMembershipRepository groupMembershipRepository;

    public AuthorizationService(VehicleAuthorizationRepository vehicleAuthorizationRepository, VehicleGroupMembershipRepository groupMembershipRepository) {
        this.vehicleAuthorizationRepository = vehicleAuthorizationRepository;
        this.groupMembershipRepository = groupMembershipRepository;
    }


    public void authorizeUserToVehicle(Long userId, Long vehicleId) {
        VehicleAuthorization authorization = new VehicleAuthorization();
        authorization.setUserId(userId);
        authorization.setVehicleId(vehicleId);
        vehicleAuthorizationRepository.save(authorization);
    }

    public String login(User user) {
        return "Success";
    }

    public void unauthorizeUserFromVehicle(Long userId, Long vehicleId) {
        vehicleAuthorizationRepository.deleteByUserIdAndVehicleId(userId, vehicleId);
    }

    public void authorizeUserToGroup(Long userId, Long groupId) {
        VehicleGroupMembership membership = new VehicleGroupMembership();
        membership.setUserId(userId);
        membership.setGroupId(groupId);
        groupMembershipRepository.save(membership);
    }

    public void unauthorizeUserFromGroup(Long userId, Long groupId) {
        groupMembershipRepository.deleteByUserIdAndGroupId(userId, groupId);
    }

}

