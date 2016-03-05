package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typewritting database table.
 * 
 */
@Entity
@NamedQuery(name="Typewritting.findAll", query="SELECT t FROM Typewritting t")
public class Typewritting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int typeWrittingId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Writting
	@OneToMany(mappedBy="typewritting")
	private List<Writting> writtings;

	public Typewritting() {
	}

	public int getTypeWrittingId() {
		return this.typeWrittingId;
	}

	public void setTypeWrittingId(int typeWrittingId) {
		this.typeWrittingId = typeWrittingId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Writting> getWrittings() {
		return this.writtings;
	}

	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}

	public Writting addWritting(Writting writting) {
		getWrittings().add(writting);
		writting.setTypewritting(this);

		return writting;
	}

	public Writting removeWritting(Writting writting) {
		getWrittings().remove(writting);
		writting.setTypewritting(null);

		return writting;
	}

}