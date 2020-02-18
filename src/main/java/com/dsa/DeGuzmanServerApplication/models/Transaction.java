package com.dsa.DeGuzmanServerApplication.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "TRANSACTION")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class Transaction {
	
	public Long transactionid;
	public double amount;
	public int transactionType;
	public String recipient;
	public String transactionDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + transactionType;
		result = prime * result + ((transactionid == null) ? 0 : transactionid.hashCode());
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
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionType != other.transactionType)
			return false;
		if (transactionid == null) {
			if (other.transactionid != null)
				return false;
		} else if (!transactionid.equals(other.transactionid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", amount=" + amount + ", transactionType="
				+ transactionType + ", recipient=" + recipient + ", transactionDate=" + transactionDate + "]";
	}
	
	public Transaction(Long transactionid, double amount, int transactionType, String recipient, String transactionDate) {
		super();
		this.transactionid = transactionid;
		this.amount = amount;
		this.transactionType = transactionType;
		this.recipient = recipient;
		this.transactionDate = transactionDate;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
