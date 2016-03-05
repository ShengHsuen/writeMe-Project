package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.repositories.UserRepository;


@Service
public class UsersService implements UsersServiceInterface{
	@Autowired 
	private UserRepository userRepository;	

	@Override
	@Transactional
	public List<UserPOJO> getAll(UsersRequest ur) {
		List<User> users =  userRepository.findAll();
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public List<UserPOJO> getAllByName(UsersRequest ur) {
		List<User> users =  userRepository.findByNameContaining(ur.getSearchTerm());
		return generateUserDtos(users);
	}
	
	private List<UserPOJO> generateUserDtos(List<User> users){
		List<UserPOJO> uiUsers = new ArrayList<UserPOJO>();
		users.stream().forEach(u -> {
			UserPOJO dto = new UserPOJO();
			BeanUtils.copyProperties(u,dto);
			dto.setPassword("");
			uiUsers.add(dto);
		});	
		return uiUsers;
	}
	
	@Override
	@Transactional
	public Boolean saveUser(UsersRequest ur) {
		User user = new User();
		BeanUtils.copyProperties(ur.getUser(), user);
		user.setPassword("set md5 password");


		
		User nuser = userRepository.save(user);
		
		return (nuser == null) ? false : true;
	}
}
