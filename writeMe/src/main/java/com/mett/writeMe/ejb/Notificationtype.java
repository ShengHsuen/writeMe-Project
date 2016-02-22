package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notificationtype database table.
 * 
 */
@Entity
@NamedQuery(name="Notificationtype.findAll", query="SELECT n FROM Notificationtype n")
public class Notificationtype implements Serializable {
	private static final long serialVersionUID = 1L;
	private int notificationTypeId;
	private String name;
	private Notification notification;

	public Notificationtype() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getNotificationTypeId() {
		return this.notificationTypeId;
	}

	public void setNotificationTypeId(int notificationTypeId) {
		this.notificationTypeId = notificationTypeId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Notification
	@ManyToOne
	public Notification getNotification() {
		return this.notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}