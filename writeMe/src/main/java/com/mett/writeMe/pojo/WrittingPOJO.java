package com.mett.writeMe.pojo;

import java.util.Date;
import java.util.List;

import com.mett.writeMe.ejb.Category;
import com.mett.writeMe.ejb.Chapter;
import com.mett.writeMe.ejb.Mylibrary;
import com.mett.writeMe.ejb.Record;
import com.mett.writeMe.ejb.Restriction;
import com.mett.writeMe.ejb.Typewritting;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;

public class WrittingPOJO {
	private int writtingId;
	private Long cantUsers;
	private Date date;
	private String description;
	private Long likes;
	private Date limitTime;
	private String name;
	private Long numMaxCharacters;
	private Long numMinCharacters;
	private boolean participation;
	private boolean published;
	private Category category;
	private Record record;
	private Restriction restriction;
	private Typewritting typewritting;
	private Writting writting;
	
	private List<Writting> writtings;
	private List<Chapter> chapters;
	private List<Mylibrary> mylibraries;
	private List<UserHasWritting> userHasWrittings;
	public int getWrittingId() {
		return writtingId;
	}
	public void setWrittingId(int writtingId) {
		this.writtingId = writtingId;
	}
	public Long getCantUsers() {
		return cantUsers;
	}
	public void setCantUsers(Long cantUsers) {
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
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
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
	public Long getNumMaxCharacters() {
		return numMaxCharacters;
	}
	public void setNumMaxCharacters(Long numMaxCharacters) {
		this.numMaxCharacters = numMaxCharacters;
	}
	public Long getNumMinCharacters() {
		return numMinCharacters;
	}
	public void setNumMinCharacters(Long numMinCharacters) {
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
	public List<Writting> getWrittings() {
		return writtings;
	}
	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	public List<Mylibrary> getMylibraries() {
		return mylibraries;
	}
	public void setMylibraries(List<Mylibrary> mylibraries) {
		this.mylibraries = mylibraries;
	}
	public List<UserHasWritting> getUserHasWrittings() {
		return userHasWrittings;
	}
	public void setUserHasWrittings(List<UserHasWritting> userHasWrittings) {
		this.userHasWrittings = userHasWrittings;
	}
	
}
