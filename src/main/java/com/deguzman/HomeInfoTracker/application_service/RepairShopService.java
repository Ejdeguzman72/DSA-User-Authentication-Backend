package com.deguzman.HomeInfoTracker.application_service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.HomeInfoTracker.application_models.RepairShop;
import com.deguzman.HomeInfoTracker.application_repository.RepairShopRepository;
import com.deguzman.HomeInfoTracker.exception.RepairSopNotFoundException;
import com.deguzman.HomeInfoTracker.exception.ResourceNotFoundException;
import com.deguzman.HomeInfoTracker.logger.AutomotiveLogger;
import com.deguzman.HomeInfoTracker.logger.MedicalLogger;
import com.deguzman.HomeInfoTracker.logger_message.LoggerErrorMessage;
import com.deguzman.HomeInfoTracker.logger_message.LoggerInfoMessage;

@Service
public class RepairShopService {

	@Autowired
	private RepairShopRepository repairShopRepository;

	/**
	 * rettrieves all repair shop information and collects it onto a list
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public List<RepairShop> getAllRepairShops() throws SecurityException, IOException 
	{
		AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.GET_ALL_REPAIR_SHOP_INFO_MSG);
		return repairShopRepository.findAll();
	}
	
	/**
	 * passes repairShopId as an argument
	 * retrieves the Repair Shop Information 
	 * @param repairShopId
	 * @return
	 * @throws RepairSopNotFoundException 
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public ResponseEntity<RepairShop> getRepairShopById(@PathVariable Long repairShopId) throws RepairSopNotFoundException, SecurityException, IOException
	{
		if (repairShopId != null)
		{
			AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.GET_REPAIR_SHOP_INFO_BY_ID_MSG);			
		}
		else 
		{
			AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.REPAIR_SHOP_ID_NULL_ERROR_MSG);
		}
		RepairShop repairShop = repairShopRepository.findById(repairShopId)
				.orElseThrow(() -> new RepairSopNotFoundException("Repair shop not found with ID: " + repairShopId));
		
		return ResponseEntity.ok().body(repairShop);
	}
	
	
	/**
	 * passes shoName as an argument
	 * retrieves the repair shop information that matches with the name
	 * @param shopname
	 * @return
	 */
	public ResponseEntity<List<RepairShop>> getRepairShopByName(@PathVariable String shopname)
	{
		List<RepairShop> repairShop = repairShopRepository.getRepairShopsByName(shopname);
		return ResponseEntity.ok().body(repairShop);
	}
	
	public RepairShop createRepairShop(@Valid @RequestBody RepairShop repairShop) throws SecurityException, IOException {
		
		AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.ADD_REPAIR_SHOP_INFO_MSG + repairShop);
		return repairShopRepository.save(repairShop);
	}
	
	
	/**
	 * updates the information based on the id of the repair Shop
	 * @param repairShopId
	 * @param repairShopDetails
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<RepairShop> updateRepairShop(@PathVariable Long repairShopId, 
			@Valid @RequestBody RepairShop repairShopDetails) throws RepairSopNotFoundException, SecurityException, IOException
	{
		if (repairShopId != null)
		{
			AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.UPDATE_REPAIR_SHOP_INFO_MSG + repairShopId);			
		}
		else 
		{
			AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.REPAIR_SHOP_ID_NULL_ERROR_MSG);
		}
		
		RepairShop repairShop = repairShopRepository.findById(repairShopId)
				.orElseThrow(() -> new RepairSopNotFoundException("cannot find"));
		repairShop.setAddress(repairShopDetails.getAddress());
		repairShop.setCity(repairShopDetails.getCity());
		repairShop.setShopName(repairShopDetails.getShopName());
		repairShop.setState(repairShopDetails.getState());
		repairShop.setZip(repairShopDetails.getZip());
		final RepairShop updatedRepairShop = repairShopRepository.save(repairShop);
		
		return ResponseEntity.ok(updatedRepairShop);
	
	}
	
	/**
	 * deletes the repair shop information based on the id that is passed
	 * @param repairShopId
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public Map<String, Boolean> deleteRepairShop(@PathVariable Long repairShopId) throws SecurityException, IOException {
		
		if (repairShopId != null)
		{
			AutomotiveLogger.automotiveLogger.info(LoggerInfoMessage.DELETE_REPAIR_SHOP_INFO_MSG + repairShopId);			
		}
		else 
		{
			AutomotiveLogger.automotiveLogger.info(LoggerErrorMessage.REPAIR_SHOP_ID_NULL_ERROR_MSG);
		}
		
		repairShopRepository.deleteById(repairShopId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
}
