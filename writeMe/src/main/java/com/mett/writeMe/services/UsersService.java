package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.ejb.User;

import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.repositories.UserHasWrittingRepository;
import com.mett.writeMe.repositories.UserRepository;
import com.mett.writeMe.repositories.WrittingRepository;


/**
 * @author Dani
 * @author Sheng
 */
@Service
public class UsersService implements UsersServiceInterface{
	private User u = new User();
	private LoginServiceInterface LoginService;
	@Autowired 
	private UserRepository userRepository;	
	@Autowired 
	private UserHasWrittingRepository userHasWrittingRepository;


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
	public List<WrittingPOJO> getWrittingsByUser(HttpSession currentSession){
		int idUser = (int)currentSession.getAttribute("idUser");
		User user = userRepository.findOne(idUser);
		List<UserHasWritting> UserHasWrittings = userHasWrittingRepository.findAll();
		List<WrittingPOJO> writtings = new ArrayList<WrittingPOJO>();
	
		for (int i=0; i<= UserHasWrittings.size()-1; i++){
			if (user.getUserId() == UserHasWrittings.get(i).getUser().getUserId()){
				WrittingPOJO dto = new WrittingPOJO();
				BeanUtils.copyProperties(UserHasWrittings.get(i).getWritting(), dto);
				writtings.add(dto);
			}else{
				
			}
		}
		return writtings;
	}
}
