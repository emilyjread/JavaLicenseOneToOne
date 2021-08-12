package com.example.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {

}
