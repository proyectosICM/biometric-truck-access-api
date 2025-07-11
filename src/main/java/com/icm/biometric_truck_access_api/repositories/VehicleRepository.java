package com.icm.biometric_truck_access_api.repositories;

import com.icm.biometric_truck_access_api.models.VehicleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
    List<VehicleModel> findByCompanyId(Long companyId);
    Page<VehicleModel> findByCompanyId(Long companyId, Pageable pageable);
}
