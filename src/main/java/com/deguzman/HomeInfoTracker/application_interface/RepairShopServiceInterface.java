package com.deguzman.HomeInfoTracker.application_interface;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.RepairShop;

public interface RepairShopServiceInterface {

	public List<RepairShop> getAllRepairShops();
	
	public ResponseEntity<RepairShop> getRepairShopById(@PathVariable Long repairShopId);
	
	public RepairShop addRepairShop(@Valid @RequestBody RepairShop repairShop);
	
	public ResponseEntity<RepairShop> updateRepairShop(@PathVariable Long repairShopId,
			@Valid @RequestBody RepairShop repairShopDetails);
	
	public Map<String,Boolean> deleteRepairShop(@PathVariable Long repairShopId);
}
