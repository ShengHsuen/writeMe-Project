package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.contracts.BaseResponse;
import com.mett.writeMe.pojo.UserPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UserPOJO> usuarios;

	public UsersResponse() {
		super();
	}
	
	public List<UserPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UserPOJO> usuarios) {
		this.usuarios = usuarios;
	}

}