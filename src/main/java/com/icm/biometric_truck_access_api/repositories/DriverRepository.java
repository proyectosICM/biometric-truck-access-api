package com.icm.biometric_truck_access_api.repositories;

import com.icm.biometric_truck_access_api.models.DriverModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long> {

    DriverModel findByEmail(String email);
    DriverModel findByLicensePlate(String licensePlate);
    DriverModel findByDni(String dni);
    List<DriverModel> findByCompanyId(Long companyId);
    Page<DriverModel> findByCompanyId(Long companyId, Pageable pageable);
}
