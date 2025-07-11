package com.icm.biometric_truck_access_api.services;

import com.icm.biometric_truck_access_api.models.VehicleModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Optional<VehicleModel> findById(Long id);
    List<VehicleModel> findAll();
    Page<VehicleModel> findAll(int page, int size);
    List<VehicleModel> findByCompanyId(Long companyId);
    Page<VehicleModel> findByCompanyId(Long companyId, int page, int size);
    VehicleModel save(VehicleModel vehicle);
    VehicleModel update(Long id, VehicleModel vehicle);

}
