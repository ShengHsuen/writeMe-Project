package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private int userId;
	private byte accountType;
	private byte admin;
	private String author;
	private Date birthDay;
	private String lastName;
	private String mail;
	private String name;
	private String password;
	private List<Binnacle> binnacles;
	private List<LegalEstablishment> legalEstablishments;
	private List<Message> messages;
	private List<Notification> notifications;
	private List<Payaccount> payaccounts;
	private List<Record> records;
	private City city;
	private Mylibrary mylibrary;
	private List<User> users1;
	private List<User> users2;
	private List<UserHasWritting> userHasWrittings;

	public User() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public byte getAccountType() {
		return this.accountType;
	}

	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}


	public byte getAdmin() {
		return this.admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}


	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	//bi-directional many-to-one association to Binnacle
	@OneToMany(mappedBy="user")
	public List<Binnacle> getBinnacles() {
		return this.binnacles;
	}

	public void setBinnacles(List<Binnacle> binnacles) {
		this.binnacles = binnacles;
	}

	public Binnacle addBinnacle(Binnacle binnacle) {
		getBinnacles().add(binnacle);
		binnacle.setUser(this);

		return binnacle;
	}

	public Binnacle removeBinnacle(Binnacle binnacle) {
		getBinnacles().remove(binnacle);
		binnacle.setUser(null);

		return binnacle;
	}


	//bi-directional many-to-one association to LegalEstablishment
	@OneToMany(mappedBy="user")
	public List<LegalEstablishment> getLegalEstablishments() {
		return this.legalEstablishments;
	}

	public void setLegalEstablishments(List<LegalEstablishment> legalEstablishments) {
		this.legalEstablishments = legalEstablishments;
	}

	public LegalEstablishment addLegalEstablishment(LegalEstablishment legalEstablishment) {
		getLegalEstablishments().add(legalEstablishment);
		legalEstablishment.setUser(this);

		return legalEstablishment;
	}

	public LegalEstablishment removeLegalEstablishment(LegalEstablishment legalEstablishment) {
		getLegalEstablishments().remove(legalEstablishment);
		legalEstablishment.setUser(null);

		return legalEstablishment;
	}


	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}


	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user")
	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
	}


	//bi-directional many-to-one association to Payaccount
	@OneToMany(mappedBy="user")
	public List<Payaccount> getPayaccounts() {
		return this.payaccounts;
	}

	public void setPayaccounts(List<Payaccount> payaccounts) {
		this.payaccounts = payaccounts;
	}

	public Payaccount addPayaccount(Payaccount payaccount) {
		getPayaccounts().add(payaccount);
		payaccount.setUser(this);

		return payaccount;
	}

	public Payaccount removePayaccount(Payaccount payaccount) {
		getPayaccounts().remove(payaccount);
		payaccount.setUser(null);

		return payaccount;
	}


	//bi-directional many-to-one association to Record
	@OneToMany(mappedBy="user")
	public List<Record> getRecords() {
		return this.records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public Record addRecord(Record record) {
		getRecords().add(record);
		record.setUser(this);

		return record;
	}

	public Record removeRecord(Record record) {
		getRecords().remove(record);
		record.setUser(null);

		return record;
	}


	//bi-directional many-to-one association to City
	@ManyToOne
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	//bi-directional many-to-one association to Mylibrary
	@ManyToOne
	public Mylibrary getMylibrary() {
		return this.mylibrary;
	}

	public void setMylibrary(Mylibrary mylibrary) {
		this.mylibrary = mylibrary;
	}


	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="subscription"
		, joinColumns={
			@JoinColumn(name="subcriberId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="publisherId")
			}
		)
	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}


	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="users1")
	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}


	//bi-directional many-to-one association to UserHasWritting
	@OneToMany(mappedBy="user")
	public List<UserHasWritting> getUserHasWrittings() {
		return this.userHasWrittings;
	}

	public void setUserHasWrittings(List<UserHasWritting> userHasWrittings) {
		this.userHasWrittings = userHasWrittings;
	}

	public UserHasWritting addUserHasWritting(UserHasWritting userHasWritting) {
		getUserHasWrittings().add(userHasWritting);
		userHasWritting.setUser(this);

		return userHasWritting;
	}

	public UserHasWritting removeUserHasWritting(UserHasWritting userHasWritting) {
		getUserHasWrittings().remove(userHasWritting);
		userHasWritting.setUser(null);

		return userHasWritting;
	}

}