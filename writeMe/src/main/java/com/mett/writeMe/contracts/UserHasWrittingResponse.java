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
	private User user;
	private Writting writting;
	
	public UserHasWrittingResponse() {
		super();
	}
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

	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUserHasWritting(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}
