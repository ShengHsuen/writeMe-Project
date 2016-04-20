package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_has_writting database table.
 * 
 */
@Entity
@Table(name="user_has_writting")
@NamedQuery(name="UserHasWritting.findAll", query="SELECT u FROM UserHasWritting u")
public class UserHasWritting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int user_has_writtingId;

	private Boolean banned;

	private Boolean canWrite;

	private Boolean confirmation;

	@Temporal(TemporalType.DATE)
	private Date dateCreate;

	@Temporal(TemporalType.DATE)
	private Date dateModifie;

	@Column(name="id_owner")
	private int idOwner;

	private Boolean invitationStatus;

	private int linkInvitation;

	private Boolean owner;

	private Boolean publicc;

	private Boolean statusColor;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="userHasWritting")
	private List<Comment> comments;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="userHasWritting")
	private List<Role> roles;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	//bi-directional many-to-one association to Writting
	@ManyToOne(fetch=FetchType.LAZY)
	private Writting writting;

	public UserHasWritting() {
	}

	public int getUser_has_writtingId() {
		return this.user_has_writtingId;
	}

	public void setUser_has_writtingId(int user_has_writtingId) {
		this.user_has_writtingId = user_has_writtingId;
	}

	public Boolean getBanned() {
		return this.banned;
	}

	public void setBanned(Boolean banned) {
		this.banned = banned;
	}

	public Boolean getCanWrite() {
		return this.canWrite;
	}

	public void setCanWrite(Boolean canWrite) {
		this.canWrite = canWrite;
	}

	public Boolean getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateModifie() {
		return this.dateModifie;
	}

	public void setDateModifie(Date dateModifie) {
		this.dateModifie = dateModifie;
	}

	public int getIdOwner() {
		return this.idOwner;
	}

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

	public Boolean getInvitationStatus() {
		return this.invitationStatus;
	}

	public void setInvitationStatus(Boolean invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	public int getLinkInvitation() {
		return this.linkInvitation;
	}

	public void setLinkInvitation(int linkInvitation) {
		this.linkInvitation = linkInvitation;
	}

	public Boolean getOwner() {
		return this.owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public Boolean getPublicc() {
		return this.publicc;
	}

	public void setPublicc(Boolean publicc) {
		this.publicc = publicc;
	}

	public Boolean getStatusColor() {
		return this.statusColor;
	}

	public void setStatusColor(Boolean statusColor) {
		this.statusColor = statusColor;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUserHasWritting(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUserHasWritting(null);

		return comment;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUserHasWritting(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUserHasWritting(null);

		return role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Writting getWritting() {
		return this.writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}

}