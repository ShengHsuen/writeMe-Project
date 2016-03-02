package com.mett.writeMe.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the legal_establishment database table.
 * 
 */
@Entity
@Table(name="legal_establishment")
@NamedQuery(name="LegalEstablishment.findAll", query="SELECT l FROM LegalEstablishment l")
public class LegalEstablishment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int legal_establishmentId;
	private String description;
	private int part;
	private String name;

	public LegalEstablishment() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLegal_establishmentId() {
		return this.legal_establishmentId;
	}

	public void setLegal_establishmentId(int legal_establishmentId) {
		this.legal_establishmentId = legal_establishmentId;
	}

	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	public int getPart() {
		return this.part;
	}

	public void setPart(int part) {
		this.part = part;
	}


	//bi-directional many-to-one association to User
	/*@ManyToOne
	public User getUser() {
		return this.user;
	}*/
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


}