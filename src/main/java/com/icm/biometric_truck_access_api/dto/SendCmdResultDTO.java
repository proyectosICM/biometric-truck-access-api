package com.icm.biometric_truck_access_api.dto;

import lombok.Data;

@Data
public class SendCmdResultDTO extends DeviceAuthDTO {
    private String trans_id;
    private String cmd_return_code; // "OK" o "ERROR"
    // cuerpo específico depende del comando ejecutado
}