package com.icm.biometric_truck_access_api.services;

import com.icm.biometric_truck_access_api.models.CompanyModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyModel> findById(Long id);
    List<CompanyModel> findAll();
    Page<CompanyModel> findAll(int page, int size);
    CompanyModel save(CompanyModel company);
    CompanyModel update(Long id, CompanyModel company);

}
