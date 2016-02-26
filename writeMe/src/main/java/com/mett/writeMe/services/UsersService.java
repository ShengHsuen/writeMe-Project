package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.services.UsersServiceInterface;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UsuarioPOJO;
import com.mett.writeMe.repositories.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface{
	@Autowired private UsersRepository usersRepository;
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAll(UsersRequest ur) {
		List<User> users =  usersRepository.findAll();
		return generateUserDtos(users);
	}
	
	@Override
	@Transactional
	public List<UsuarioPOJO> getAllByName(UsersRequest ur) {
		List<User> users =  usersRepository.findByFirstnameContaining(ur.getSearchTerm());
		return generateUserDtos(users);
	}
	
	private List<UsuarioPOJO> generateUserDtos(List<User> users){
		List<UsuarioPOJO> uiUsers = new ArrayList<UsuarioPOJO>();
		users.stream().forEach(u -> {
			UsuarioPOJO dto = new UsuarioPOJO();
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
		
		User nuser = usersRepository.save(user);
		
		return (nuser == null) ? false : true;
		
	}
}
