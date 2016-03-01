package com.mett.writeMe.services;

<<<<<<< HEAD
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;

public interface UsersServiceInterface {
=======
import java.util.List;

import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.contracts.UsersRequest;

public interface UsersServiceInterface {

	List<UserPOJO> getAll(UsersRequest ur);
	List<UserPOJO> getAllByName(UsersRequest ur);
>>>>>>> 8cadc2bcf83f59a201448c7f9e9797dc94aa3a2b
	Boolean saveUser(UsersRequest ur);
}
