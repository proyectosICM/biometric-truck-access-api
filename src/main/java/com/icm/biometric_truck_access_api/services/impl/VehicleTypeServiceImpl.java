package com.icm.biometric_truck_access_api.services.impl;

import com.icm.biometric_truck_access_api.models.VehicleTypeModel;
import com.icm.biometric_truck_access_api.repositories.VehicleTypeRepository;
import com.icm.biometric_truck_access_api.services.VehicleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    public Optional<VehicleTypeModel> findById(Long id) {
        return vehicleTypeRepository.findById(id);
    }

    public List<VehicleTypeModel> findAll() {
        return vehicleTypeRepository.findAll();
    }

    public Page<VehicleTypeModel> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleTypeRepository.findAll(pageable);
    }

    public List<VehicleTypeModel> findByCompanyId(Long companyId) {
        return vehicleTypeRepository.findByCompanyId(companyId);
    }

    public Page<VehicleTypeModel> findByCompanyId(Long companyId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleTypeRepository.findByCompanyId(companyId, pageable);
    }

    public VehicleTypeModel save(VehicleTypeModel vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public VehicleTypeModel update(Long id, VehicleTypeModel vehicleType) {
        return vehicleTypeRepository.findById(id)
                .map(existingVehicleType -> {
                    existingVehicleType.setName(vehicleType.getName());
                    existingVehicleType.setDescription(vehicleType.getDescription());
                    // Add other fields to update as necessary
                    return vehicleTypeRepository.save(existingVehicleType);
                })
                .orElseThrow(() -> new RuntimeException("Vehicle Type not found with id: " + id));
    }
}
