package com.mett.writeMe.contracts;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.contracts.BaseRequest;

public class UserHasWrittingRequest extends BaseRequest{
	
	private UserHasWrittingPOJO userHasWritting;
	private String resultFileName;
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
