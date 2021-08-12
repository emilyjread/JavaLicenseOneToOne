package com.example.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.relationships.models.License;
import com.example.relationships.repositories.LicenseRepo;

@Service
public class LicenseService {
	private LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo= licenseRepo;
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }


}
