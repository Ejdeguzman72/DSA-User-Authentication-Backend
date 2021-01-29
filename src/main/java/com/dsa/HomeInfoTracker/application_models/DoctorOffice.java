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
@Table(name = "DOCTOR_OFFICE")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorOffice {
	
	public Long doctorOfficeId;
	public Long doctorOfficeTypeId;
	public String name;
	public String address;
	public String city;
	public String state;
	public String zip;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDoctorOfficeId() {
		return doctorOfficeId;
	}
	public void setDoctorOfficeId(Long doctorOfficeId) {
		this.doctorOfficeId = doctorOfficeId;
	}
	public Long getDoctorOfficeTypeId() {
		return doctorOfficeTypeId;
	}
	public void setDoctorOfficeTypeId(Long doctorOfficeTypeId) {
		this.doctorOfficeTypeId = doctorOfficeTypeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((doctorOfficeId == null) ? 0 : doctorOfficeId.hashCode());
		result = prime * result + ((doctorOfficeTypeId == null) ? 0 : doctorOfficeTypeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DoctorOffice other = (DoctorOffice) obj;
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
		if (doctorOfficeId == null) {
			if (other.doctorOfficeId != null)
				return false;
		} else if (!doctorOfficeId.equals(other.doctorOfficeId))
			return false;
		if (doctorOfficeTypeId == null) {
			if (other.doctorOfficeTypeId != null)
				return false;
		} else if (!doctorOfficeTypeId.equals(other.doctorOfficeTypeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "DoctorOffice [doctorOfficeId=" + doctorOfficeId + ", doctorOfficeTypeId=" + doctorOfficeTypeId
				+ ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}
	
	public DoctorOffice(Long doctorOfficeId, Long doctorOfficeTypeId, String name, String address, String city,
			String state, String zip) {
		super();
		this.doctorOfficeId = doctorOfficeId;
		this.doctorOfficeTypeId = doctorOfficeTypeId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public DoctorOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
