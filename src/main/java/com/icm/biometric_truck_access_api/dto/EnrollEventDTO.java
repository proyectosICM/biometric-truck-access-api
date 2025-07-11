package com.icm.biometric_truck_access_api.dto;

import lombok.Data;

// Evento de inscripción remota (realtime_enroll_data)
@Data
public class EnrollEventDTO extends UserDTO {
    private String tiempo;
}
