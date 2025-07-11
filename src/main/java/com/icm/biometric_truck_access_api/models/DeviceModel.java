package com.icm.biometric_truck_access_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "devices")
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id; // dev_id
    private String model; // dev_model
    private String firmwareVersion;
    private String name;
    private String token; // hash md5(dev_id + key)
    private LocalDateTime lastSeen;
}
