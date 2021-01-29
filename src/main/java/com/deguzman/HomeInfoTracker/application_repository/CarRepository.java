package com.deguzman.HomeInfoTracker.application_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deguzman.HomeInfoTracker.application_models.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

	@Query(value = "SELECT * FROM car_tbl WHERE make = ?1", nativeQuery=true)
	List<Car> findCarsByMake(String make);
	
	@Query(value = "SELECT * FROM car_tbl WHERE model = ?1", nativeQuery=true)
	List<Car> findCarsByModel(String model);
	
	@Query(value = "SELECT * FROM car_tbl WHERE capacity = ?1", nativeQuery=true)
	List<Car> findCarsByCapacity(int capacity);
	
	@Query(value = "SELECT * FROM car_tbl WHERE transmission = ?1", nativeQuery=true)
	List<Car> findCarsByTransmission(String transmission);
}
