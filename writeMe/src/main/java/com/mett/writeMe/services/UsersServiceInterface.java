package com.mett.writeMe.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;


public interface UsersServiceInterface {
    
	List<UserPOJO> getAll(UsersRequest ur);
	List<UserPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
	void deleteUser (int idUser);
	User getUserByMail(UsersRequest ur);
	List<WrittingPOJO> getWrittingsByUser(HttpSession currentSession);
}
