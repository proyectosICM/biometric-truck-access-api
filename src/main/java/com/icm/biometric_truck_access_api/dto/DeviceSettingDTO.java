package com.icm.biometric_truck_access_api.dto;

import lombok.Data;

// Configuración del dispositivo (SET_DEVICE_SETTING)
@Data
public class DeviceSettingDTO {
    private String deviceName;
    private String serverHost;
    private Integer serverPort;
    private String idioma;
    private Integer volumen;
    private Boolean antiPass;
    private Integer doorOpenDelay;
    private String verificationMode;
    private String oldPwd;
    private String newPwd;
    // Agrega los que necesites según el protocolo
}
