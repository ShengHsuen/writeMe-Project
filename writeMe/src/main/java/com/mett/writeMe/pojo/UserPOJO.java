package com.mett.writeMe.pojo;

import java.util.Date;
import java.util.List;

public class UserPOJO{
	
	private int userId;
<<<<<<< HEAD
	private byte accountType;
	private byte admin;
=======
	private boolean accountType;
	private boolean admin;
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
	private String author;
	private Date birthDay;
	private String lastName;
	private String mail;
	private String name;
	private String password;

	public UserPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

<<<<<<< HEAD
	public byte accountType(){
		return accountType;
	}
	
	public void setAccountType(byte accountType){
		this.accountType = accountType;
	}
	
	public byte getAdmin(){
		return admin;
	}
	
	public void setAdmin(byte admin){
=======
	public boolean accountType(){
		return accountType;
	}
	
	public void setAccountType(boolean accountType){
		this.accountType = accountType;
	}
	
	public boolean getAdmin(){
		return admin;
	}
	
	public void setAdmin(boolean admin){
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
		this.admin = admin;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public Date getBirthDay(){
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay){
		this.birthDay = birthDay;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getMail(){
		return mail;
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
