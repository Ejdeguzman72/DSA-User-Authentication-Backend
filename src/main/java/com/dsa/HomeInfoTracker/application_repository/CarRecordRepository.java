package com.dsa.HomeInfoTracker.application_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.HomeInfoTracker.application_models.CarRecord;

@Repository
public interface CarRecordRepository extends JpaRepository<CarRecord, Long> {
	
	@Query(value = "SELECT * FROM car_record_tbl WHERE carJobId ?1", nativeQuery=true)
	List<CarRecord> findCarRecordByCarJobId(Long carJobId);
	
	@Query(value = "SELECT * FROM car_record_tbl WHERE repairShopId = ?1", nativeQuery=true)
	List<CarRecord> findCarRecordByRepairShopId(Long repairShopId);
	
	@Query(value = "SELECT * FROM car_record_tbl WHERE amount = ?1", nativeQuery=true)
	List<CarRecord> findCarRecordByAmount(double amount);
	
	@Query(value = "SELECT * FROM car_record_tbl WHERE amount >= ?1", nativeQuery=true)
	List<CarRecord> findCarRecordByGreaterThanOrEqualToAmount(double amount);
	
	@Query(value = "SELECT * FROM car_record_tbl WHERE amount <= ?1", nativeQuery=true)
	List<CarRecord> findCarRecordByLessThanOrEqualAmount(double amount);
	
}
