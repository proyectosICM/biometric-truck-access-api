package com.icm.biometric_truck_access_api.controllers;

import com.icm.biometric_truck_access_api.models.DriverModel;
import com.icm.biometric_truck_access_api.models.VehicleTypeModel;
import com.icm.biometric_truck_access_api.services.VehicleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle-types")
public class VehicleTypeController {
    private final VehicleTypeService vehicleTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleTypeModel> getVehicleTypeById(@PathVariable Long id) {
        return vehicleTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VehicleTypeModel>> getAllVehicleTypes() {
        List<VehicleTypeModel> vehicleTypes = vehicleTypeService.findAll();
        return ResponseEntity.ok(vehicleTypes);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<VehicleTypeModel>> getAllVehicleTypesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<VehicleTypeModel> vehicleTypes = vehicleTypeService.findAll(page, size);
        return ResponseEntity.ok(vehicleTypes);
    }

    @GetMapping("/by-company/{companyId}")
    public ResponseEntity<List<VehicleTypeModel>> getVehicleTypesByCompanyId(@PathVariable Long companyId) {
        List<VehicleTypeModel> vehicleTypes = vehicleTypeService.findByCompanyId(companyId);
        if (vehicleTypes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicleTypes);
    }

    @GetMapping("/by-company-paginated/{companyId}")
    public ResponseEntity<Page<VehicleTypeModel>> getVehicleTypesByCompanyIdPaginated(
            @PathVariable Long companyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<VehicleTypeModel> vehicleTypes = vehicleTypeService.findByCompanyId(companyId, page, size);
        if (vehicleTypes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicleTypes);
    }

    @PostMapping
    public ResponseEntity<VehicleTypeModel> createVehicleType(@RequestBody VehicleTypeModel vehicleType) {
        VehicleTypeModel savedVehicleType = vehicleTypeService.save(vehicleType);
        return ResponseEntity.status(201).body(savedVehicleType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleTypeModel> updateVehicleType(@PathVariable Long id, @RequestBody VehicleTypeModel vehicleType) {
        VehicleTypeModel updateVehicleType = vehicleTypeService.update(id, vehicleType);
        if (updateVehicleType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateVehicleType);
    }
}
