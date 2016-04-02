package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.UserHasWrittingRepository;
import com.mett.writeMe.repositories.UserRepository;
import com.mett.writeMe.repositories.WrittingRepository;


/**
 * @author Dani
 * @author Sheng
 */
@Service
public class UsersService implements UsersServiceInterface{
	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private UserHasWrittingRepository userHasWrittingRepository;	
	@Autowired 
	private WrittingRepository writtingRepository;

	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#getAll(com.mett.writeMe.contracts.UsersRequest)
	 */
	@Override
	@Transactional
	public List<UserPOJO> getAll() {
		List<User> users =  userRepository.findAllByOrderByAuthor();
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

	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#deleteUser(int)
	 */
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

	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#getWrittingsByUser(javax.servlet.http.HttpSession)
	 */
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UsersServiceInterface#getWrittingsByUser(javax.servlet.http.HttpSession)
	 */
	@Override
	@Transactional
	public List<WrittingPOJO> getWrittingsByUser(HttpSession currentSession){
		int idUser = (int)currentSession.getAttribute("idUser");
		User user = userRepository.findOne(idUser);
		List<UserHasWritting> userHasWrittings = userHasWrittingRepository.findAll();
		List<WrittingPOJO> writtings = new ArrayList<WrittingPOJO>();
	
		for (int i=0; i<= userHasWrittings.size()-1; i++){
			if (user.getUserId() == userHasWrittings.get(i).getUser().getUserId()){
				WrittingPOJO dto = new WrittingPOJO();
				BeanUtils.copyProperties(userHasWrittings.get(i).getWritting(), dto);
				writtings.add(dto);
			}else{
				
			}
		}
		return writtings;
	}
	
	@Override
	@Transactional
	public List<String> getUsersOwner(List<WrittingPOJO> wpojo, String userTerm) {
		List<UserHasWritting> uhw = userHasWrittingRepository.findAll();
		List<User> user = userRepository.findByAuthorContaining(userTerm); //Siempre sera un usuario el que recibe
		System.out.println("userrr: " + user.get(0).getAuthor());
		List<String> us = new ArrayList<String>();
		List<UserHasWritting> uhowner = userHasWrittingRepository.findAllByOwnerTrue();
		
		//List<UserHasWritting> uh = userHasWrittingRepository.findAllBylinkInvitation(wpojo.get(0).getWrittingId());
		
		/*for(int i=0;i<=wpojo.size()-1;i++){
			if(uhowner.get(i).getUser() == uh.get(i).getUser()){
				System.out.println("IF ");
			}
		}*/
		
		int j=0;
		for(int i=0;i<=uhw.size()-1;i++){
			System.out.println("1 Author Us: " + user.get(0).getAuthor());
			System.out.println("2 Author UHW: " + uhw.get(i).getUser().getAuthor());
			//uhw.get(i).getLinkInvitation() == wpojo.get(j).getWrittingId() && 
			if(user.get(0).getAuthor().equals(uhw.get(i).getUser().getAuthor())){
				System.out.println("getUsersOwner entre al if");
				us.add(uhowner.get(j).getUser().getAuthor());
				System.out.println("J: " + j);
				j++;
			}
			System.out.println("i: " + i);
		}
		
		return us;
	}

}
