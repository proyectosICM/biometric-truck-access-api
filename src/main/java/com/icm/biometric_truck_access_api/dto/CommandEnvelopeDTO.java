package com.icm.biometric_truck_access_api.dto;

import lombok.Data;

// un CommandEnvelopeDTO que represente cualquier comando enviado o recibido y tenga:
@Data
public class CommandEnvelopeDTO {
    private String codigoSolicitud;
    private String cmdCode;
    private String transId;
    private DeviceAuthDTO auth;
    private Object body; // luego haces casting según el cmdCode
}
