package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int commentId;
	private String comment;
	private Date date;
	private String likes;
	private UserHasWritting userHasWritting;

	public Comment() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Lob
	public String getLikes() {
		return this.likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}


	//bi-directional many-to-one association to UserHasWritting
	@ManyToOne
	@JoinColumn(name="user_has_writting_user_has_writtingId")
	public UserHasWritting getUserHasWritting() {
		return this.userHasWritting;
	}

	public void setUserHasWritting(UserHasWritting userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}