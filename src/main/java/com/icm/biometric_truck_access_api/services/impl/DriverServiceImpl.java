package com.icm.biometric_truck_access_api.services.impl;

import com.icm.biometric_truck_access_api.models.DriverModel;
import com.icm.biometric_truck_access_api.repositories.DriverRepository;
import com.icm.biometric_truck_access_api.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public Optional<DriverModel> findById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public List<DriverModel> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Page<DriverModel> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return driverRepository.findAll(pageable);
    }

    @Override
    public List<DriverModel> findByCompanyId(Long companyId) {
        return driverRepository.findByCompanyId(companyId);
    }

    @Override
    public Page<DriverModel> findByCompanyId(Long companyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return driverRepository.findByCompanyId(companyId, pageable);
    }

    @Override
    public DriverModel save(DriverModel driver) {
        return driverRepository.save(driver);
    }

    @Override
    public DriverModel update(Long id, DriverModel driver) {
        return driverRepository.findById(id)
                .map(existingDriver -> {
                    existingDriver.setName(driver.getName());
                    //existingDriver.setCompanyId(driver.getCompanyId());
                    // Add other fields to update as necessary
                    return driverRepository.save(existingDriver);
                })
                .orElseThrow(() -> new IllegalArgumentException("Driver with id " + id + " does not exist."));
    }
}
