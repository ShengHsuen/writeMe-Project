package com.mett.writeMe.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.repositories.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface{
	@Autowired 
	private UsersRepository usersRepository;

	@Override
	@Transactional
	public Boolean saveUser(UsersRequest ur) {
		User user = new User();
		BeanUtils.copyProperties(ur.getUser(), user);
		
		User nuser = usersRepository.save(user);
		
		return (nuser == null) ? false : true;	
	}
}
