package com.example.Mobiliz.ServiceImpl;

import com.example.Mobiliz.dao.VehicleAuthorizationRepository;
import com.example.Mobiliz.dao.VehicleGroupMembershipRepository;
import com.example.Mobiliz.model.User;
import com.example.Mobiliz.service.AuthorizationService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl extends AuthorizationService {

    public AuthorizationServiceImpl(VehicleAuthorizationRepository vehicleAuthorizationRepository, VehicleGroupMembershipRepository groupMembershipRepository) {
        super(vehicleAuthorizationRepository, groupMembershipRepository);
    }

    @Override
    public String login(User user) {
        return "JWT_TOKEN";
    }

}
