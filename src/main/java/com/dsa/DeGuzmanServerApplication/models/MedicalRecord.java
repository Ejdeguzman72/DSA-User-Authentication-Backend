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
@Table(name = "MEDICAL_RECORD")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class MedicalRecord {
	
	public Long medicalRecordId;
	public Long doctorOfficeId;
	public Long personid;
	public double amount;
	public String doctorName;
	public String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public Long getDoctorOfficeId() {
		return doctorOfficeId;
	}
	public void setDoctorOfficeId(Long doctorOfficeId) {
		this.doctorOfficeId = doctorOfficeId;
	}
	public Long getPersonid() {
		return personid;
	}
	public void setPersonid(Long personid) {
		this.personid = personid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result + ((doctorOfficeId == null) ? 0 : doctorOfficeId.hashCode());
		result = prime * result + ((medicalRecordId == null) ? 0 : medicalRecordId.hashCode());
		result = prime * result + ((personid == null) ? 0 : personid.hashCode());
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
		MedicalRecord other = (MedicalRecord) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (doctorOfficeId == null) {
			if (other.doctorOfficeId != null)
				return false;
		} else if (!doctorOfficeId.equals(other.doctorOfficeId))
			return false;
		if (medicalRecordId == null) {
			if (other.medicalRecordId != null)
				return false;
		} else if (!medicalRecordId.equals(other.medicalRecordId))
			return false;
		if (personid == null) {
			if (other.personid != null)
				return false;
		} else if (!personid.equals(other.personid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MedicalRecord [medicalRecordId=" + medicalRecordId + ", doctorOfficeId=" + doctorOfficeId
				+ ", personid=" + personid + ", amount=" + amount + ", doctorName=" + doctorName + ", description="
				+ description + "]";
	}
	
	public MedicalRecord(Long medicalRecordId, Long doctorOfficeId, Long personid, double amount, String doctorName,
			String description) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.doctorOfficeId = doctorOfficeId;
		this.personid = personid;
		this.amount = amount;
		this.doctorName = doctorName;
		this.description = description;
	}
	
	public MedicalRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
