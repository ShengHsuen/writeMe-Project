package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;


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
	private String part;
	private User user;

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


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Lob
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
		this.user = user;
	}

}