package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.contracts.BaseResponse;

public class UserHasWrittingResponse extends BaseResponse{
	private List<UserHasWrittingPOJO> userHasWritting;

	public UserHasWrittingResponse() {
		super();
	}
	
	public List<UserHasWrittingPOJO> getUsuarios() {
		return userHasWritting;
	}

	public void setUsuarios(List<UserHasWrittingPOJO> usuarios) {
		this.userHasWritting = userHasWritting;
	}
}
