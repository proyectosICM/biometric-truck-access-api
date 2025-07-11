package com.icm.biometric_truck_access_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Evento de inscripción en tiempo real, si quieres rastrear cambios
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enroll_events")
public class EnrollEventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userId;

    @ManyToOne
    private DeviceModel deviceModel;

    private LocalDateTime timestamp;

    @Lob
    private String rawData; // JSON completo, si quieres auditar
}
