package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;


public class UsersResponse extends BaseResponse{
	
	private List<UserPOJO> users;
	private List<WrittingPOJO> writting;

	public UsersResponse() {
		super();
	}
	
	public List<UserPOJO> getUsers() {
		return users;
	}

	public void setUsers(List<UserPOJO> users) {

		this.users = users;
	}

	public List<WrittingPOJO> getWritting() {
		return writting;
	}

	public void setWritting(List<WrittingPOJO> writting) {
		this.writting = writting;
	}
	
	

}