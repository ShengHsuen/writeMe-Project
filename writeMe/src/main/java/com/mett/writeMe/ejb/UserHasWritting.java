package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
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
	private int user_has_writtingId;
	private boolean banned;
	private boolean statusColor;
	private List<Comment> comments;
	private List<Report> reports;
	private List<Typeuser> typeusers;
	private User user;
	private Writting writting;

	public UserHasWritting() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUser_has_writtingId() {
		return this.user_has_writtingId;
	}

	public void setUser_has_writtingId(int user_has_writtingId) {
		this.user_has_writtingId = user_has_writtingId;
	}


	public boolean getBanned() {
		return this.banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}


	public boolean getStatusColor() {
		return this.statusColor;
	}

	public void setStatusColor(boolean statusColor) {
		this.statusColor = statusColor;
	}


	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="userHasWritting")
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


	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="userHasWritting")
	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setUserHasWritting(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setUserHasWritting(null);

		return report;
	}


	//bi-directional many-to-one association to Typeuser
	@OneToMany(mappedBy="userHasWritting")
	public List<Typeuser> getTypeusers() {
		return this.typeusers;
	}

	public void setTypeusers(List<Typeuser> typeusers) {
		this.typeusers = typeusers;
	}

	public Typeuser addTypeuser(Typeuser typeuser) {
		getTypeusers().add(typeuser);
		typeuser.setUserHasWritting(this);

		return typeuser;
	}

	public Typeuser removeTypeuser(Typeuser typeuser) {
		getTypeusers().remove(typeuser);
		typeuser.setUserHasWritting(null);

		return typeuser;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//bi-directional many-to-one association to Writting
	@ManyToOne
	public Writting getWritting() {
		return this.writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}

}