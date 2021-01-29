package com.deguzman.HomeInfoTracker.application_controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.HomeInfoTracker.application_models.RepairShop;
import com.deguzman.HomeInfoTracker.application_repository.RepairShopRepository;
import com.deguzman.HomeInfoTracker.application_service.RepairShopService;
import com.deguzman.HomeInfoTracker.exception.RepairSopNotFoundException;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app/repair-shops")
public class RepairShopController {

	@Autowired
	private RepairShopService repairShopService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public List<RepairShop> getAllRepairShops() throws SecurityException, IOException {
		return repairShopService.getAllRepairShops();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/repair-shop/{repairShopId}")
	public ResponseEntity<RepairShop> getRepairShopById(@PathVariable Long repairShopId) throws RepairSopNotFoundException, SecurityException, IOException 
	{
		return repairShopService.getRepairShopById(repairShopId);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/repair-shop/shopname/{shopname}")
	public ResponseEntity<List<RepairShop>> getRepairShopByName(@PathVariable String shopname)
	{
		return repairShopService.getRepairShopByName(shopname);
	}
	
//	@GetMapping("/repair-shop/location/{address,city,state}")
//	public ResponseEntity<RepairShop> getRepairShopByLocation(
//			@PathVariable String address,city,state)
//	{
//		
//	}
	
	// input fields that are entered. it will save the repair shop
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add-a-repair-shop")
	public RepairShop createRepairShop(@Valid @RequestBody RepairShop repairShop) throws SecurityException, IOException 
	{
		return repairShopService.createRepairShop(repairShop);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/repair-shop/{repairShopId}")
	public ResponseEntity<RepairShop> updateRepairShop(@PathVariable Long repairShopId, 
			@Valid @RequestBody RepairShop repairShopDetails) throws RepairSopNotFoundException, SecurityException, IOException
	{
		return repairShopService.updateRepairShop(repairShopId, repairShopDetails);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/repair-shop/{repairShopId}")
	public Map<String, Boolean> deleteRepairShop(@PathVariable Long repairShopId) throws SecurityException, IOException 
	{
		return repairShopService.deleteRepairShop(repairShopId);
	}
}
