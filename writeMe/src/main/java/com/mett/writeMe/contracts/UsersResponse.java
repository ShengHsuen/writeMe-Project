package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.contracts.BaseResponse;
import com.mett.writeMe.pojo.UsuarioPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UsuarioPOJO> usuarios;

	public UsersResponse() {
		super();
	}
	
	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
	}

}