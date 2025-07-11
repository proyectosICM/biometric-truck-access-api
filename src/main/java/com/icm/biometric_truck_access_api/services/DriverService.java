package com.icm.biometric_truck_access_api.services;

import com.icm.biometric_truck_access_api.models.DriverModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    Optional<DriverModel> findById(Long id);
    List<DriverModel> findAll();
    Page<DriverModel> findAll(int page, int size);
    List<DriverModel> findByCompanyId(Long companyId);
    Page<DriverModel> findByCompanyId(Long companyId, int page, int size);
    DriverModel save(DriverModel driver);
    DriverModel update(Long id, DriverModel driver);
}
