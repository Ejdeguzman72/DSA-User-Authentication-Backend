package com.deguzman.HomeInfoTracker.authentication_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.HomeInfoTracker.authentication_models.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Long>, JpaSpecificationExecutor<Users>{
	
	Users findUserByUsername(String username);
	List<Users> findAll();
}
