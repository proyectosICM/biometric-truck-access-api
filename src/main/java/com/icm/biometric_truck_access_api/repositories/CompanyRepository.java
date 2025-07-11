package com.icm.biometric_truck_access_api.repositories;

import com.icm.biometric_truck_access_api.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {

}
