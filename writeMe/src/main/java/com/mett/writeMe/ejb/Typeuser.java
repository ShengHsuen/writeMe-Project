package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the typeuser database table.
 * 
 */
@Entity
@NamedQuery(name="Typeuser.findAll", query="SELECT t FROM Typeuser t")
public class Typeuser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idtypeUser;
	private String description;
	private String typeName;
	private UserHasWritting userHasWritting;

	public Typeuser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdtypeUser() {
		return this.idtypeUser;
	}

	public void setIdtypeUser(int idtypeUser) {
		this.idtypeUser = idtypeUser;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	//bi-directional many-to-one association to UserHasWritting
	@ManyToOne
	@JoinColumn(name="user_has_writting_user_has_writtingId")
	public UserHasWritting getUserHasWritting() {
		return this.userHasWritting;
	}

	public void setUserHasWritting(UserHasWritting userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}