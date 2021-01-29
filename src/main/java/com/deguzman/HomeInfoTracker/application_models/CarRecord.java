package com.deguzman.HomeInfoTracker.application_models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "CAR_RECORD")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class CarRecord {
	
	public Long carRecordId;
	public Long repairShopId;
	public Long carJobId;
	public double amount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCarRecordId() {
		return carRecordId;
	}
	public void setCarRecordId(Long carRecordId) {
		this.carRecordId = carRecordId;
	}
	public Long getRepairShopId() {
		return repairShopId;
	}
	public void setRepairShopId(Long repairShopId) {
		this.repairShopId = repairShopId;
	}
	public Long getCarJobId() {
		return carJobId;
	}
	public void setCarJobId(Long carJobId) {
		this.carJobId = carJobId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		long result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(amount);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		result = prime * result + carJobId;
//		result = prime * result + carRecordId;
//		result = prime * result + repairShopId;
//		return result;
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarRecord other = (CarRecord) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (carJobId != other.carJobId)
			return false;
		if (carRecordId != other.carRecordId)
			return false;
		if (repairShopId != other.repairShopId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CarRecord [carRecordId=" + carRecordId + ", repairShopId=" + repairShopId + ", carJobId=" + carJobId
				+ ", amount=" + amount + "]";
	}
	public CarRecord(Long carRecordId, Long repairShopId, Long carJobId, double amount) {
		super();
		this.carRecordId = carRecordId;
		this.repairShopId = repairShopId;
		this.carJobId = carJobId;
		this.amount = amount;
	}
	public CarRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
