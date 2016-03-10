package com.mett.writeMe.services;

import java.util.List;


import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UserPOJO;


public interface UsersServiceInterface {

	List<UserPOJO> getAll(UsersRequest ur);
	List<UserPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
	User getUserByMail(UsersRequest ur);
}
