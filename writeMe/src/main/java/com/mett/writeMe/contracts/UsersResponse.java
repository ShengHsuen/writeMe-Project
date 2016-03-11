package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UserHasWrittingPOJO> userHasWritting;

	public UsersResponse() {
		super();
	}
	
	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUsuarios(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}