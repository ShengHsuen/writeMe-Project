package com.mett.writeMe.contracts;

import com.mett.writeMe.contracts.BaseRequest;
import com.mett.writeMe.pojo.UserPOJO;

public class UsersRequest extends BaseRequest {
	
	private UserPOJO user;
	
	public UsersRequest() {
		super();
	}
	
	public UserPOJO getUser() {
		return user;
	}
	
	public void setUser(UserPOJO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsersRequest [user=" + user + "]";
	}
}