package com.mett.writeMe.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.mett.writeMe.ejb.User;

public class LegalEstablishmentPOJO {
	private int legal_establishmentId;
	private String description;
	private String part;
	private User user;

	public LegalEstablishmentPOJO() {
		super();
	}

	public int getLegal_establishmentId() {
		return this.legal_establishmentId;
	}

	public void setLegal_establishmentId(int legal_establishmentId) {
		this.legal_establishmentId = legal_establishmentId;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	public String getPart() {
		return this.part;
	}

	public void setPart(String part) {
		this.part = part;
	}


	//bi-directional many-to-one association to User Mildred
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = null;
	}

}