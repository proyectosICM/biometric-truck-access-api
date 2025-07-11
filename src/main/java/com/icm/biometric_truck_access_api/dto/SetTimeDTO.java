package com.icm.biometric_truck_access_api.dto;

import lombok.Data;

// Sincronizar hora (SET_TIME)
@Data
public class SetTimeDTO {
    private String syncTime; // "aaaaMMddHHmmss"
}