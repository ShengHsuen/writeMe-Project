package com.mett.writeMe.contracts;

import java.util.ArrayList;
import java.util.List;

import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;

public class UserHasWrittingResponse extends BaseResponse{
	private List<UserHasWrittingPOJO> userHasWritting;
	private UserHasWritting uhw;
	private List<UserPOJO> luser = new ArrayList<UserPOJO>();
	
	public List<UserPOJO> getLuser() {
		return luser;
	}

	public void setLuser(List<UserPOJO> luser) {
		this.luser = luser;
	}

	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUserHasWritting(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

	public UserHasWritting getUhw() {
		return uhw;
	}

	public void setUhw(UserHasWritting uhw) {
		this.uhw = uhw;
	}
	


}
