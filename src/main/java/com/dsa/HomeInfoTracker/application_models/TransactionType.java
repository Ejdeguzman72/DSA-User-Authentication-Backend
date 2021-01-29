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
@Table(name = "TRANSACTION_TYPE")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionType {
	
	Long transactionTypeId;
	String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getTransactionTypeId() {
		return transactionTypeId;
	}
	public void setTransactionTypeId(Long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
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
		result = prime * result + ((transactionTypeId == null) ? 0 : transactionTypeId.hashCode());
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
		TransactionType other = (TransactionType) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (transactionTypeId == null) {
			if (other.transactionTypeId != null)
				return false;
		} else if (!transactionTypeId.equals(other.transactionTypeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionType [transactionTypeId=" + transactionTypeId + ", description=" + description + "]";
	}
	public TransactionType(Long transactionTypeId, String description) {
		super();
		this.transactionTypeId = transactionTypeId;
		this.description = description;
	}
	public TransactionType() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
