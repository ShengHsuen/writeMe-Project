package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UserHasWrittingPOJO> userHasWritting;
	private List<WrittingPOJO> writtings;
	public UsersResponse() {
		super();
	}
	
	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUsuarios(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}
	
	public List<WrittingPOJO> getWrittings() {
		return writtings;

	}
	public void setWrittings(List<WrittingPOJO> writtings) {
		this.writtings = writtings;
	}

}