package com.icm.biometric_truck_access_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Registro de comandos enviados a los dispositivos
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "command_logs")
public class CommandLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transId; // trans_id

    @ManyToOne
    private DeviceModel deviceModel;

    private String cmdCode;
    private String status; // PENDING, OK, ERROR
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @Lob
    private String payload;     // JSON enviado
    @Lob
    private String response;    // JSON recibido
}
