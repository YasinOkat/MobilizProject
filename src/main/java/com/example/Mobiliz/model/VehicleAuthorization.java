package com.example.Mobiliz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_authorizations")
public class VehicleAuthorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long vehicleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "VehicleAuthorization{" +
                "id=" + id +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                '}';
    }

}
