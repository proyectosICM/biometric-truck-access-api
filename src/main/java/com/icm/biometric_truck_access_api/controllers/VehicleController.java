package com.icm.biometric_truck_access_api.controllers;

import com.icm.biometric_truck_access_api.models.VehicleModel;
import com.icm.biometric_truck_access_api.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> getVehicleById(@PathVariable Long id) {
        return vehicleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> getAllVehicles() {
        List<VehicleModel> vehicles = vehicleService.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<VehicleModel>> getAllVehiclesPaginated(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size) {
        Page<VehicleModel> vehicles = vehicleService.findAll(page, size);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/by-company/{companyId}")
    public ResponseEntity<List<VehicleModel>> getVehiclesByCompanyId(@PathVariable Long companyId) {
        List<VehicleModel> vehicles = vehicleService.findByCompanyId(companyId);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/by-company-paginated/{companyId}")
    public ResponseEntity<Page<VehicleModel>> getVehiclesByCompanyIdPaginated(
            @PathVariable Long companyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<VehicleModel> vehicles = vehicleService.findByCompanyId(companyId, page, size);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<VehicleModel> createVehicle(@RequestBody VehicleModel vehicle) {
        VehicleModel savedVehicle = vehicleService.save(vehicle);
        return ResponseEntity.status(201).body(savedVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleModel> updateVehicle(@PathVariable Long id, @RequestBody VehicleModel vehicle) {
        VehicleModel updatedVehicle = vehicleService.update(id, vehicle);
        if (updatedVehicle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVehicle);
    }
}
