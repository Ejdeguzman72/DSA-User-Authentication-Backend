package com.dsa.DeGuzmanServerApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dsa.DeGuzmanServerApplication.models.DoctorOffice;

public interface DoctorOfficeRepository extends JpaRepository<DoctorOffice, Long> {

}