package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the record database table.
 * 
 */
@Entity
@NamedQuery(name="Record.findAll", query="SELECT r FROM Record r")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recordId;
	private Date date;
	private Object state;
	private User user;
	private List<Writting> writtings;

	public Record() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getRecordId() {
		return this.recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Object getState() {
		return this.state;
	}

	public void setState(Object state) {
		this.state = state;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//bi-directional many-to-one association to Writting
	@OneToMany(mappedBy="record")
	public List<Writting> getWrittings() {
		return this.writtings;
	}

	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}

	public Writting addWritting(Writting writting) {
		getWrittings().add(writting);
		writting.setRecord(this);

		return writting;
	}

	public Writting removeWritting(Writting writting) {
		getWrittings().remove(writting);
		writting.setRecord(null);

		return writting;
	}

}