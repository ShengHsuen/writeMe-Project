package com.mett.writeMe.services;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;

public interface UsersServiceInterface {
	Boolean saveUser(UsersRequest ur);
}
