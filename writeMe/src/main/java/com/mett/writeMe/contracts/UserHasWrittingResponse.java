package com.mett.writeMe.contracts;

import java.util.Date;
import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.contracts.BaseResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;

public class UserHasWrittingResponse extends BaseResponse{
	private List<UserHasWrittingPOJO> userHasWritting;
	private UserHasWritting uhw;
	private boolean banned;

	private Date dateCreate;

	private Date dateModifie;

	private boolean invitationStatus;

	private int linkInvitation;

	private boolean statusColor;
	
	private boolean owner;

	private User user;
	
	private Writting writting;

	public UserHasWritting getUhw() {
		return uhw;
	}

	public void setUhw(UserHasWritting uhw) {
		this.uhw = uhw;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Writting getWritting() {
		return writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}

	public UserHasWrittingResponse() {
		super();
	}

	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUserHasWritting(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateModifie() {
		return dateModifie;
	}

	public void setDateModifie(Date dateModifie) {
		this.dateModifie = dateModifie;
	}

	public boolean isInvitationStatus() {
		return invitationStatus;
	}

	public void setInvitationStatus(boolean invitationStatus) {
		this.invitationStatus = invitationStatus;
	}

	public int getLinkInvitation() {
		return linkInvitation;
	}

	public void setLinkInvitation(int linkInvitation) {
		this.linkInvitation = linkInvitation;
	}

	public boolean isStatusColor() {
		return statusColor;
	}

	public void setStatusColor(boolean statusColor) {
		this.statusColor = statusColor;
	}

	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	


}
