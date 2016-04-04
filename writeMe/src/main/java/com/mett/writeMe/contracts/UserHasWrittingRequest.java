package com.mett.writeMe.contracts;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.contracts.BaseRequest;

public class UserHasWrittingRequest extends BaseRequest{
	
	private UserHasWrittingPOJO userHasWritting;
	private WrittingPOJO writting;
	public WrittingPOJO getWritting() {
		return writting;
	}

	public void setWritting(WrittingPOJO writting) {
		this.writting = writting;
	}

	private UserPOJO user;
	private String resultFileName;
	
	public UserPOJO getUser() {
		return user;
	}

	public void setUser(UserPOJO user) {
		this.user = user;
	}
	
	public UserHasWrittingRequest() {
		super();
	}
	
	public UserHasWrittingPOJO getUserHasWritting() {
		return userHasWritting;
	}
	
	public void setUserHasWritting(UserHasWrittingPOJO userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

	@Override
	public String toString() {
		return "UserHasWrittingRequest [userHasWritting=" + userHasWritting + "]";
	}

}
