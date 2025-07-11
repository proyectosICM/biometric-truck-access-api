package com.icm.biometric_truck_access_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Eventos recibidos en tiempo real (verificación biométrica)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AccessEvent")
public class AccessEventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userId;

    @ManyToOne
    private DeviceModel device;

    private LocalDateTime timestamp;
    private String verifyMode;   // "Huella", "Rostro", etc.
    private String inOut;        // "Entrada", "Salida"
    private String doorMode;     // "auto", "mano_abierta", etc.

    @Lob
    private String logPhoto;     // Base64

    private Integer ioMode;
}
