package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the writting database table.
 * 
 */
@Entity
@NamedQuery(name="Writting.findAll", query="SELECT w FROM Writting w")
public class Writting implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private List<Chapter> chapters;
	private List<UserHasWritting> userHasWrittings;
	private Category category;
	private List<Mylibrary> mylibraries;
	private Record record;
	private Restriction restriction;
	private Typewritting typewritting;
	private Writting writting;
	private List<Writting> writtings;

	public Writting() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getWrittingId() {
		return this.writtingId;
	}

	public void setWrittingId(int writtingId) {
		this.writtingId = writtingId;
	}


	@Lob
	public String getCantUsers() {
		return this.cantUsers;
	}

	public void setCantUsers(String cantUsers) {
		this.cantUsers = cantUsers;
	}


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Lob
	public String getLikes() {
		return this.likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}


	@Temporal(TemporalType.DATE)
	public Date getLimitTime() {
		return this.limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Lob
	public String getNumMaxCharacters() {
		return this.numMaxCharacters;
	}

	public void setNumMaxCharacters(String numMaxCharacters) {
		this.numMaxCharacters = numMaxCharacters;
	}


	@Lob
	public String getNumMinCharacters() {
		return this.numMinCharacters;
	}

	public void setNumMinCharacters(String numMinCharacters) {
		this.numMinCharacters = numMinCharacters;
	}


	public boolean getParticipation() {
		return this.participation;
	}

	public void setParticipation(boolean participation) {
		this.participation = participation;
	}


	public boolean getPublished() {
		return this.published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}


	//bi-directional many-to-one association to Chapter
	@OneToMany(mappedBy="writting")
	public List<Chapter> getChapters() {
		return this.chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public Chapter addChapter(Chapter chapter) {
		getChapters().add(chapter);
		chapter.setWritting(this);

		return chapter;
	}

	public Chapter removeChapter(Chapter chapter) {
		getChapters().remove(chapter);
		chapter.setWritting(null);

		return chapter;
	}


	//bi-directional many-to-one association to UserHasWritting
	@OneToMany(mappedBy="writting")
	public List<UserHasWritting> getUserHasWrittings() {
		return this.userHasWrittings;
	}

	public void setUserHasWrittings(List<UserHasWritting> userHasWrittings) {
		this.userHasWrittings = userHasWrittings;
	}

	public UserHasWritting addUserHasWritting(UserHasWritting userHasWritting) {
		getUserHasWrittings().add(userHasWritting);
		userHasWritting.setWritting(this);

		return userHasWritting;
	}

	public UserHasWritting removeUserHasWritting(UserHasWritting userHasWritting) {
		getUserHasWrittings().remove(userHasWritting);
		userHasWritting.setWritting(null);

		return userHasWritting;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-many association to Mylibrary
	@ManyToMany
	@JoinTable(
		name="mylibrary_has_writting"
		, joinColumns={
			@JoinColumn(name="writting_writtingId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="myLibrary_myLibraryId")
			}
		)
	public List<Mylibrary> getMylibraries() {
		return this.mylibraries;
	}

	public void setMylibraries(List<Mylibrary> mylibraries) {
		this.mylibraries = mylibraries;
	}


	//bi-directional many-to-one association to Record
	@ManyToOne
	public Record getRecord() {
		return this.record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}


	//bi-directional many-to-one association to Restriction
	@ManyToOne
	public Restriction getRestriction() {
		return this.restriction;
	}

	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}


	//bi-directional many-to-one association to Typewritting
	@ManyToOne
	public Typewritting getTypewritting() {
		return this.typewritting;
	}

	public void setTypewritting(Typewritting typewritting) {
		this.typewritting = typewritting;
	}


	//bi-directional many-to-one association to Writting
	@ManyToOne
	@JoinColumn(name="writting_father")
	public Writting getWritting() {
		return this.writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}


	//bi-directional many-to-one association to Writting
	@OneToMany(mappedBy="writting")
	public List<Writting> getWrittings() {
		return this.writtings;
	}

	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}

	public Writting addWritting(Writting writting) {
		getWrittings().add(writting);
		writting.setWritting(this);

		return writting;
	}

	public Writting removeWritting(Writting writting) {
		getWrittings().remove(writting);
		writting.setWritting(null);

		return writting;
	}

}