package com.mett.writeMe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mett.writeMe.ejb.User;
import com.mett.writeMe.repositories.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface{
	@Autowired 
	private UsersRepository usersRepository;

	@Override
	public Boolean addUser(User user) {
		User nuser = usersRepository.save(user);
		return (nuser == null) ? false : true;
	}
}
