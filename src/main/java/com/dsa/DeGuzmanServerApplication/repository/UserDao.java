package com.dsa.DeGuzmanServerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users>{
	
	Users findUserByUsername(String username);
}
