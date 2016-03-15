package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.ejb.User;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.repositories.UserRepository;


/**
 * @author Dani
 * @author Sheng
 */
@Service
public class UsersService implements UsersServiceInterface{
	@Autowired 
	private UserRepository userRepository;	

	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#getAll(com.mett.writeMe.contracts.UsersRequest)
	 */
	@Override
	@Transactional
	public List<UserPOJO> getAll(UsersRequest ur) {
		List<User> users =  userRepository.findAll();
		return generateUserDtos(users);
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#getAllByName(com.mett.writeMe.contracts.UsersRequest)
	 */
	@Override
	@Transactional
	public List<UserPOJO> getAllByName(UsersRequest ur) {
		List<User> users =  userRepository.findByNameContaining(ur.getSearchTerm());
		return generateUserDtos(users);
	}
	
	/**
	 * @param users
	 * @return
	 */
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
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#saveUser(com.mett.writeMe.contracts.UsersRequest)
	 */
	@Override
	@Transactional
	public Boolean saveUser(UsersRequest ur) {
		User user = new User();
		BeanUtils.copyProperties(ur.getUser(), user);
		//user.setPassword("set md5 password");
		
		User nuser = userRepository.save(user);
		
		return (nuser == null) ? false : true;
	}
	
	@Override
	public void deleteUser(int idUser){
	   userRepository.delete(idUser);
	}
	
	@Override
	@Transactional
	public User getUserByMail(UsersRequest ur) {
		User user = new User();
		user= userRepository.findByMail(ur.getEmail());
		return  user;
	}
	
	@Override
	@Transactional
	public List<UserPOJO> getWrittings(UsersRequest us){
		User user = userRepository.findOne(1); // por el momento quemado
		List<UserPOJO> dtos = new ArrayList<UserPOJO>();
		UserPOJO dto = new UserPOJO();
		
		BeanUtils.copyProperties(user,dto);
		
		List<UserHasWrittingPOJO> userHasWrittings = new ArrayList<UserHasWrittingPOJO>();
		user.getUserHasWrittings().stream().forEach(uhw ->{
			UserHasWrittingPOJO uhwDto = new UserHasWrittingPOJO();
			BeanUtils.copyProperties(uhw,uhwDto);
			userHasWrittings.add(uhwDto);
		});
		dto.setUserHasWrittings(userHasWrittings);
		dtos.add(dto);
		return dtos;
		
	}
}
