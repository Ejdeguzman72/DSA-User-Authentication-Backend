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
@Table(name = "CARJOB")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class CarJob {
	
	Long carjobid;
	String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCarjobid() {
		return carjobid;
	}
	public void setCarjobid(Long carjobid) {
		this.carjobid = carjobid;
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
		result = prime * result + ((carjobid == null) ? 0 : carjobid.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		CarJob other = (CarJob) obj;
		if (carjobid == null) {
			if (other.carjobid != null)
				return false;
		} else if (!carjobid.equals(other.carjobid))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CarJob [carjobid=" + carjobid + ", description=" + description + "]";
	}
	public CarJob(Long carjobid, String description) {
		super();
		this.carjobid = carjobid;
		this.description = description;
	}
	public CarJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
