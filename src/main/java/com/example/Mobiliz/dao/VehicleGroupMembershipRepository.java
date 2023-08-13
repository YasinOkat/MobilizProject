package com.example.Mobiliz.dao;

import com.example.Mobiliz.model.VehicleGroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleGroupMembershipRepository extends JpaRepository<VehicleGroupMembership, Long> {

    void deleteByUserIdAndGroupId(Long userId, Long groupId);
}

