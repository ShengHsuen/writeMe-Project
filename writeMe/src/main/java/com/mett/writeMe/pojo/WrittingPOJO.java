package com.mett.writeMe.pojo;

import java.util.Date;

public class WrittingPOJO {
	private int writtingId;
	private String cantUsers;
	private Date date;
	private String description;
	private String likes;
	private Date limitTime;
	private String name;
	private String numMaxCharacters;
	private String numMinCharacters;
	private boolean participation;
	private boolean published;
	
	public WrittingPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWrittingId() {
		return writtingId;
	}

	public void setWrittingId(int writtingId) {
		this.writtingId = writtingId;
	}

	public String getCantUsers() {
		return cantUsers;
	}

	public void setCantUsers(String cantUsers) {
		this.cantUsers = cantUsers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumMaxCharacters() {
		return numMaxCharacters;
	}

	public void setNumMaxCharacters(String numMaxCharacters) {
		this.numMaxCharacters = numMaxCharacters;
	}

	public String getNumMinCharacters() {
		return numMinCharacters;
	}

	public void setNumMinCharacters(String numMinCharacters) {
		this.numMinCharacters = numMinCharacters;
	}

	public boolean isParticipation() {
		return participation;
	}

	public void setParticipation(boolean participation) {
		this.participation = participation;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	
}
