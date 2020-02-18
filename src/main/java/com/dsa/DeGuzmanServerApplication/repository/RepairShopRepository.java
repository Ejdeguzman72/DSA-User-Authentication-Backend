package com.dsa.DeGuzmanServerApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsa.DeGuzmanServerApplication.models.RepairShop;

@Repository
public interface RepairShopRepository extends JpaRepository<RepairShop, Long>{

	@Query(value = "SELECT * FROM repair_shop_tbl WHERE shop_name = ?1", nativeQuery=true)
	List<RepairShop> getRepairShopsByName(String shopname);
	
	@Query(value = "SELECT * FROM repair_shop_tbl WHERE address = ?1 AND city = ?2 and state = ?3", nativeQuery=true)
	RepairShop getRepairShopByAddress(String address, String city, String state);
}
