package com.mett.writeMe.contracts;

import java.util.Date;

import com.mett.writeMe.ejb.Category;
import com.mett.writeMe.ejb.Record;
import com.mett.writeMe.ejb.Restriction;
import com.mett.writeMe.ejb.Typewritting;
import com.mett.writeMe.ejb.Writting;

public class WrittingRequest {
	private String cantUsers;
	private Date date;
	private String description;
	private String likes;
	private Date limitTime;
	private String name;
	private String numMaxCharacters;
	private String numMinCharacters;
	private byte participation;
	private byte published;
	private Category category;
	private Record record;
	private Restriction restriction;
	private Typewritting typewritting;
	private Writting writting;
	
	public WrittingRequest(String cantUsers, Date date, String description, String likes,
			Date limitTime, String name, String numMaxCharacters, String numMinCharacters, byte participation,
			byte published, Category category, Record record, Restriction restriction, Typewritting typewritting,
			Writting writting) {
		super();
		this.cantUsers = cantUsers;
		this.date = date;
		this.description = description;
		this.likes = likes;
		this.limitTime = limitTime;
		this.name = name;
		this.numMaxCharacters = numMaxCharacters;
		this.numMinCharacters = numMinCharacters;
		this.participation = participation;
		this.published = published;
		this.category = category;
		this.record = record;
		this.restriction = restriction;
		this.typewritting = typewritting;
		this.writting = writting;
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

	public byte getParticipation() {
		return participation;
	}

	public void setParticipation(byte participation) {
		this.participation = participation;
	}

	public byte getPublished() {
		return published;
	}

	public void setPublished(byte published) {
		this.published = published;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Restriction getRestriction() {
		return restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}

	public Typewritting getTypewritting() {
		return typewritting;
	}

	public void setTypewritting(Typewritting typewritting) {
		this.typewritting = typewritting;
	}

	public Writting getWritting() {
		return writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}


	

	
	
	
}
