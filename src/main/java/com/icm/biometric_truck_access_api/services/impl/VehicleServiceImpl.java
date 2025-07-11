package com.icm.biometric_truck_access_api.services.impl;

import com.icm.biometric_truck_access_api.models.VehicleModel;
import com.icm.biometric_truck_access_api.repositories.VehicleRepository;
import com.icm.biometric_truck_access_api.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Optional<VehicleModel> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<VehicleModel> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Page<VehicleModel> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public List<VehicleModel> findByCompanyId(Long companyId) {
        return vehicleRepository.findByCompanyId(companyId);
    }

    @Override
    public Page<VehicleModel> findByCompanyId(Long companyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleRepository.findByCompanyId(companyId, pageable);
    }

    @Override
    public VehicleModel save(VehicleModel vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleModel update(Long id, VehicleModel vehicle) {
        return vehicleRepository.findById(id)
                .map(existing -> {
                    existing.setLicensePlate(vehicle.getLicensePlate());
                    existing.setVehicleType(vehicle.getVehicleType());
                    //existing.setDriver(vehicle.getDriver());
                    // Add other fields to update as necessary
                    return vehicleRepository.save(existing);
                }).orElseThrow(() -> new IllegalArgumentException("Vehicle with id " + id + " does not exist."));
    }
}
