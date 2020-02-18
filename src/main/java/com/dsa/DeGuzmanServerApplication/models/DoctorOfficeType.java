package com.dsa.DeGuzmanServerApplication.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "DOCTOR_OFFICE_TYPE")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorOfficeType {
	
	public Long doctorOfficeTypeId;
	public String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDoctorOfficeTypeId() {
		return doctorOfficeTypeId;
	}
	public void setDoctorOfficeTypeId(Long doctorOfficeTypeId) {
		this.doctorOfficeTypeId = doctorOfficeTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((doctorOfficeTypeId == null) ? 0 : doctorOfficeTypeId.hashCode());
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
		DoctorOfficeType other = (DoctorOfficeType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (doctorOfficeTypeId == null) {
			if (other.doctorOfficeTypeId != null)
				return false;
		} else if (!doctorOfficeTypeId.equals(other.doctorOfficeTypeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DoctorOfficeType [doctorOfficeTypeId=" + doctorOfficeTypeId + ", description=" + description + "]";
	}
	public DoctorOfficeType(Long doctorOfficeTypeId, String description) {
		super();
		this.doctorOfficeTypeId = doctorOfficeTypeId;
		this.description = description;
	}
	public DoctorOfficeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
