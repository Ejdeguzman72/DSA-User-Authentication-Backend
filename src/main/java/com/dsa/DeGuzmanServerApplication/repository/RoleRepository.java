package com.dsa.DeGuzmanServerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
