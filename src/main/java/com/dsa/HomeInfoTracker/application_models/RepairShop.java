package com.dsa.HomeInfoTracker.application_models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "REPAIR_SHOP")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class RepairShop {
	
	public Long repairShopId;
	public String shopName;
	public String address;
	public String city;
	public String state;
	public String zip;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getRepairShopId() {
		return repairShopId;
	}
	public void setRepairShopId(Long repairShopId) {
		this.repairShopId = repairShopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((repairShopId == null) ? 0 : repairShopId.hashCode());
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepairShop other = (RepairShop) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (repairShopId == null) {
			if (other.repairShopId != null)
				return false;
		} else if (!repairShopId.equals(other.repairShopId))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RepairShop [repairShopId=" + repairShopId + ", shopName=" + shopName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	public RepairShop(Long repairShopId, String shopName, String address, String city, String state, String zip) {
		super();
		this.repairShopId = repairShopId;
		this.shopName = shopName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public RepairShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
