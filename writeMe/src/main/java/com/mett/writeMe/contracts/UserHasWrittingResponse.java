package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.contracts.BaseResponse;

public class UserHasWrittingResponse extends BaseResponse{
	private List<UserHasWrittingPOJO> userHasWritting;
	private int idUserHasWritting;

	public UserHasWrittingResponse() {
		super();
	}
	
	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUserHasWritting(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

	public int getIdUserHasWritting() {
		return idUserHasWritting;
	}

	public void setIdUserHasWritting(int idUserHasWritting) {
		this.idUserHasWritting = idUserHasWritting;
	}
	
	
}
