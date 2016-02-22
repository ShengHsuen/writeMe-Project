package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the payaccount database table.
 * 
 */
@Entity
@NamedQuery(name="Payaccount.findAll", query="SELECT p FROM Payaccount p")
public class Payaccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private int payAccountId;
	private Date expirationDate;
	private String nameCard;
	private String numCard;
	private String numSecurity;
	private User user;

	public Payaccount() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPayAccountId() {
		return this.payAccountId;
	}

	public void setPayAccountId(int payAccountId) {
		this.payAccountId = payAccountId;
	}


	@Temporal(TemporalType.DATE)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getNameCard() {
		return this.nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}


	public String getNumCard() {
		return this.numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}


	public String getNumSecurity() {
		return this.numSecurity;
	}

	public void setNumSecurity(String numSecurity) {
		this.numSecurity = numSecurity;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}