package com.icm.biometric_truck_access_api.controllers;

import com.icm.biometric_truck_access_api.models.CompanyModel;
import com.icm.biometric_truck_access_api.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyModel> getCompanyById(Long id) {
        return companyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CompanyModel>> getAllCompanies() {
        List<CompanyModel> companies = companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<CompanyModel>> getAllCompaniesPaginated(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "10") int size) {
        Page<CompanyModel> companies = companyService.findAll(page, size);
        return ResponseEntity.ok(companies);
    }

    @PostMapping
    public ResponseEntity<CompanyModel> createCompany(CompanyModel company) {
        CompanyModel savedCompany = companyService.save(company);
        return ResponseEntity.ok(savedCompany);
    }

    @PutMapping
    public ResponseEntity<CompanyModel> updateCompany(@PathVariable Long id,
                                                      @RequestBody CompanyModel company) {
        CompanyModel updatedCompany = companyService.update(id, company);
        if (updatedCompany == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCompany);
    }




}
