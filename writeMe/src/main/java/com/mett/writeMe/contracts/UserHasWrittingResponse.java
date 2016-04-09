package com.mett.writeMe.contracts;

import java.util.Date;
import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.contracts.BaseResponse;

public class UserHasWrittingResponse extends BaseResponse{
	private List<UserHasWrittingPOJO> userHasWritting;
	private boolean banned;

	private Date dateCreate;

	private Date dateModifie;

	private boolean invitationStatus;

	private int linkInvitation;

	private boolean statusColor;
	
	private boolean owner;

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
