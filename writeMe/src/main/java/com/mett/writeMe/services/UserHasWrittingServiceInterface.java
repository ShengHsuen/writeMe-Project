package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.UserHasWrittingRequest;

import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;

public interface UserHasWrittingServiceInterface {
	List<UserHasWrittingPOJO> getAll();
	Boolean save(UserHasWrittingRequest ur);
	List<UserHasWrittingPOJO> getAll(UserHasWrittingRequest ur);

}
