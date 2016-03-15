package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;

public class UsersResponse extends BaseResponse{
	private List<UserPOJO> users;
	private List<WrittingPOJO> writtings;

	public UsersResponse() {
		super();
	}
	public List<UserPOJO> getUsers() {
		return users;
	}

	public void setUsers(List<UserPOJO> users) {
		this.users = users;
	}
	
	public List<WrittingPOJO> getWrittings() {
		return writtings;
	}
	public void setWrittings(List<WrittingPOJO> writtings) {
		this.writtings = writtings;
	}
	public void setWritting(List<WrittingPOJO> writtingsByUser) {
		this.writtings = writtingsByUser;
		
	}



}