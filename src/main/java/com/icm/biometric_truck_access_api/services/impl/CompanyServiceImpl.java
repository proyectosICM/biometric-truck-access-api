package com.icm.biometric_truck_access_api.services.impl;

import com.icm.biometric_truck_access_api.models.CompanyModel;
import com.icm.biometric_truck_access_api.repositories.CompanyRepository;
import com.icm.biometric_truck_access_api.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Optional<CompanyModel> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<CompanyModel> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<CompanyModel> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable);
    }

    @Override
    public CompanyModel save(CompanyModel company) {
        return companyRepository.save(company);
    }

    @Override
    public CompanyModel update(Long id, CompanyModel company) {
        return companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setName(company.getName());
                    // Add other fields to update as necessary
                    return companyRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Company with id " + id + " does not exist."));
    }

}
