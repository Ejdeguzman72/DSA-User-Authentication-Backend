package com.dsa.HomeInfoTracker.application_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsa.HomeInfoTracker.application_models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
