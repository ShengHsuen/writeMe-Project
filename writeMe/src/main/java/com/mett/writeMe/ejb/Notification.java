package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	private int notificationId;
	private User user;
	private List<Notificationtype> notificationtypes;

	public Notification() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//bi-directional many-to-one association to Notificationtype
	@OneToMany(mappedBy="notification")
	public List<Notificationtype> getNotificationtypes() {
		return this.notificationtypes;
	}

	public void setNotificationtypes(List<Notificationtype> notificationtypes) {
		this.notificationtypes = notificationtypes;
	}

	public Notificationtype addNotificationtype(Notificationtype notificationtype) {
		getNotificationtypes().add(notificationtype);
		notificationtype.setNotification(this);

		return notificationtype;
	}

	public Notificationtype removeNotificationtype(Notificationtype notificationtype) {
		getNotificationtypes().remove(notificationtype);
		notificationtype.setNotification(null);

		return notificationtype;
	}

}