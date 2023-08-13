package com.example.Mobiliz.model;


import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_groups")
public class VehicleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "VehicleGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}
