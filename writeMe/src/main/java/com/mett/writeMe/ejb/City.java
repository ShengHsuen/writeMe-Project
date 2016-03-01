package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cityId;
	private String name;
	private State state;
	private List<User> users;

	public City() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to State
	@ManyToOne
	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}


	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="city")
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setCity(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setCity(null);

		return user;
	}

}