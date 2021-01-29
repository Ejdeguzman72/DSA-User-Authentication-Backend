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
@Table(name = "CARDTYPE")
@EntityListeners(AuditingEntityListener.class)
@CrossOrigin(origins = "http://localhost:3000")
public class CardType {
	
	public Long cardTypeId;
	public String type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardTypeId == null) ? 0 : cardTypeId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CardType other = (CardType) obj;
		if (cardTypeId == null) {
			if (other.cardTypeId != null)
				return false;
		} else if (!cardTypeId.equals(other.cardTypeId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CardType [cardTypeId=" + cardTypeId + ", type=" + type + "]";
	}
	public CardType(Long cardTypeId, String type) {
		super();
		this.cardTypeId = cardTypeId;
		this.type = type;
	}
	public CardType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
