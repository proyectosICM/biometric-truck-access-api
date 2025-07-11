package com.icm.biometric_truck_access_api.controllers;

import com.icm.biometric_truck_access_api.models.DriverModel;
import com.icm.biometric_truck_access_api.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<DriverModel> getDriverById(@PathVariable Long id) {
        return driverService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DriverModel>> getAllDrivers() {
        List<DriverModel> drivers = driverService.findAll();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DriverModel>> getAllDriversPaginated(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        Page<DriverModel> drivers = driverService.findAll(page, size);
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/by-company/{companyId}")
    public ResponseEntity<List<DriverModel>> getDriversByCompanyId(@PathVariable Long companyId) {
        List<DriverModel> drivers = driverService.findByCompanyId(companyId);
        if (drivers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/by-company-paginated/{companyId}")
    public ResponseEntity<Page<DriverModel>> getDriversByCompanyIdPaginated(
            @PathVariable Long companyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Page<DriverModel> drivers = driverService.findByCompanyId(companyId, page, size);
        if (drivers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(drivers);
    }


    @PostMapping
    public ResponseEntity<DriverModel> createDriver(@RequestBody DriverModel driver) {
        DriverModel savedDriver = driverService.save(driver);
        return ResponseEntity.ok(savedDriver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverModel> updateDriver(@PathVariable Long id, @RequestBody DriverModel driver) {
        DriverModel updatedDriver = driverService.update(id, driver);
        if (updatedDriver == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDriver);
    }
}
