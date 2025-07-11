package com.icm.biometric_truck_access_api.repositories;

import com.icm.biometric_truck_access_api.models.VehicleTypeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleTypeModel, Long> {
    List<VehicleTypeModel> findByCompanyId(Long companyId);
    Page<VehicleTypeModel> findByCompanyId(Long companyId, Pageable pageable);
}
