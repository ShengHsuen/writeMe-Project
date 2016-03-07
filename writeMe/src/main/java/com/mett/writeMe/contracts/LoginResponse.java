package com.mett.writeMe.contracts;

import com.mett.writeMe.contracts.BaseResponse;

public class LoginResponse extends BaseResponse {
	
	private int idUser;
	private String name;
	private String lastName; 

	public LoginResponse() {
		super();
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}

