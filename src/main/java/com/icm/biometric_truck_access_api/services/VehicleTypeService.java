package com.icm.biometric_truck_access_api.services;

import com.icm.biometric_truck_access_api.models.VehicleTypeModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeService {
    Optional<VehicleTypeModel> findById(Long id);
    List<VehicleTypeModel> findAll();
    Page<VehicleTypeModel> findAll(int page, int size);
    List<VehicleTypeModel> findByCompanyId(Long companyId);
    Page<VehicleTypeModel> findByCompanyId(Long companyId, int page, int size);
    VehicleTypeModel save(VehicleTypeModel vehicleType);
    VehicleTypeModel update(Long id, VehicleTypeModel vehicleType);
}
