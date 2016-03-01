package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.contracts.UsersRequest;

public interface UsersServiceInterface {

	List<UserPOJO> getAll(UsersRequest ur);
	List<UserPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
}
