package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the restriction database table.
 * 
 */
@Entity
@NamedQuery(name="Restriction.findAll", query="SELECT r FROM Restriction r")
public class Restriction implements Serializable {
	private static final long serialVersionUID = 1L;
	private int restrictionId;
	private String description;
	private List<Writting> writtings;

	public Restriction() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRestrictionId() {
		return this.restrictionId;
	}

	public void setRestrictionId(int restrictionId) {
		this.restrictionId = restrictionId;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//bi-directional many-to-one association to Writting
	@OneToMany(mappedBy="restriction")
	public List<Writting> getWrittings() {
		return this.writtings;
	}

	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}

	public Writting addWritting(Writting writting) {
		getWrittings().add(writting);
		writting.setRestriction(this);

		return writting;
	}

	public Writting removeWritting(Writting writting) {
		getWrittings().remove(writting);
		writting.setRestriction(null);

		return writting;
	}

}