package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.pojo.UsuarioPOJO;

public interface UsersServiceInterface {
	List<UsuarioPOJO> getAll(UsersRequest ur);
	List<UsuarioPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
}
