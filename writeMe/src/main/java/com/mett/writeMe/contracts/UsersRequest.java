package com.mett.writeMe.contracts;

import com.mett.writeMe.contracts.BaseRequest;
import com.mett.writeMe.pojo.UsuarioPOJO;

public class UsersRequest extends BaseRequest {
	
	private UsuarioPOJO user;
	
	public UsersRequest() {
		super();
	}
	
	public UsuarioPOJO getUser() {
		return user;
	}
	
	public void setUser(UsuarioPOJO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsersRequest [user=" + user + "]";
	}
}