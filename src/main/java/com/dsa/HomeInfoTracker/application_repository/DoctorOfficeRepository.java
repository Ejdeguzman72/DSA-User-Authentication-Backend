package com.dsa.HomeInfoTracker.application_repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dsa.HomeInfoTracker.application_models.DoctorOffice;

public interface DoctorOfficeRepository extends JpaRepository<DoctorOffice, Long> {

}