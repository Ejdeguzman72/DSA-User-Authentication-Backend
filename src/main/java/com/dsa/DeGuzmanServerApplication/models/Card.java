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
@Table(name = "CARD")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class Card {
	
	public Long cardid;
	public Long cardTypeId;
	public Long bankId;
	public String name;
	public String cardNumber;
	public String expirationDate;
	public String securityCode;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public Long getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankId == null) ? 0 : bankId.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardTypeId == null) ? 0 : cardTypeId.hashCode());
		result = prime * result + ((cardid == null) ? 0 : cardid.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((securityCode == null) ? 0 : securityCode.hashCode());
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
		Card other = (Card) obj;
		if (bankId == null) {
			if (other.bankId != null)
				return false;
		} else if (!bankId.equals(other.bankId))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardTypeId == null) {
			if (other.cardTypeId != null)
				return false;
		} else if (!cardTypeId.equals(other.cardTypeId))
			return false;
		if (cardid == null) {
			if (other.cardid != null)
				return false;
		} else if (!cardid.equals(other.cardid))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (securityCode == null) {
			if (other.securityCode != null)
				return false;
		} else if (!securityCode.equals(other.securityCode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Card [cardid=" + cardid + ", cardTypeId=" + cardTypeId + ", bankId=" + bankId + ", name=" + name
				+ ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", securityCode=" + securityCode
				+ "]";
	}
	public Card(Long cardid, Long cardTypeId, Long bankId, String name, String cardNumber, String expirationDate,
			String securityCode) {
		super();
		this.cardid = cardid;
		this.cardTypeId = cardTypeId;
		this.bankId = bankId;
		this.name = name;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
