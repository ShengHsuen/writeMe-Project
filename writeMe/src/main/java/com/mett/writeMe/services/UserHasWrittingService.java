package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.repositories.UserHasWrittingRepository;

/**
 * @author Dani
 * @author Sheng
 */
@Service
public class UserHasWrittingService implements UserHasWrittingServiceInterface{
	@Autowired 
	private UserHasWrittingRepository userHasWrittingRepository;
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.UserHasWrittingServiceInterface#save(com.mett.writeMe.contracts.UserHasWrittingRequest)
	 */
	@Override
	@Transactional
	public Boolean save(UserHasWrittingRequest ur) {
		UserHasWritting userHasWritting = new UserHasWritting();
		
		BeanUtils.copyProperties(ur.getUserHasWritting(), userHasWritting);

		UserHasWritting nWritting = userHasWrittingRepository.save(userHasWritting);
		
		return (nWritting == null) ? false : true;
	}
	
	@Override
	@Transactional
	public Boolean edit(UserHasWrittingRequest ur) {
		UserHasWritting userHasWritting = new UserHasWritting();
		
		BeanUtils.copyProperties(ur.getUserHasWritting(), userHasWritting);

		UserHasWritting nWritting = userHasWrittingRepository.save(userHasWritting);
		
		return (nWritting == null) ? false : true;
	}
	
	@Override
	@Transactional
	public List<UserHasWrittingPOJO> getAll(UserHasWrittingRequest ur) {
		List<UserHasWritting> UserHasWrittings =  userHasWrittingRepository.findAll();
		return generateUserHasWrittingDtos(UserHasWrittings);
	}
	
	private List<UserHasWrittingPOJO> generateUserHasWrittingDtos(List<UserHasWritting> UserHasWrittings){
		List<UserHasWrittingPOJO> uiWrittings = new ArrayList<UserHasWrittingPOJO>();
		UserHasWrittings.stream().forEach(u -> {
			UserHasWrittingPOJO dto = new UserHasWrittingPOJO();
			BeanUtils.copyProperties(u,dto);
			uiWrittings.add(dto);
		});	
		return uiWrittings;
	}

	@Override
	public void deleteUserHaswritting(int uHwrittingId) {
		// TODO Auto-generated method stub
		userHasWrittingRepository.delete(uHwrittingId);
	}
	
	@Override
	@Transactional
	public List<UserHasWrittingPOJO> getAll() {
		List<UserHasWritting> UserHasWrittings =  userHasWrittingRepository.findAll();
		List<UserHasWrittingPOJO> dtos = new ArrayList<UserHasWrittingPOJO>();
		UserHasWrittings.stream().forEach(uw ->{
			UserHasWrittingPOJO dto = new UserHasWrittingPOJO();
			BeanUtils.copyProperties(uw, dto);
			dtos.add(dto);
		});
		return dtos;
	}
	
	@Override
	@Transactional
	public Boolean editUserHasWritting(UserHasWritting uhw) {
		uhw = userHasWrittingRepository.findByUserAndWritting(uhw.getUser(),uhw.getWritting());
		System.out.println("!!!!!!!id: " + uhw.getUser_has_writtingId());
		uhw.setInvitationStatus(true);
		UserHasWritting uhwritting = userHasWrittingRepository.save(uhw);
		return (uhwritting == null) ? false : true;
	}
	
	@Override
	@Transactional
	public Boolean deleteUserHasWritting(Writting wr, User us) {
		List<UserHasWritting> uhw = userHasWrittingRepository.findAll();
		
		uhw.stream().forEach(uh ->{
			System.out.println("US: "+ us.getAuthor());
			System.out.println("UH: "+ uh.getUser().getAuthor());
			if(uh.getWritting().getWrittingId() == wr.getWrittingId() && us.getAuthor().equals(uh.getUser().getAuthor())){
				userHasWrittingRepository.delete(uh.getUser_has_writtingId());
			}
		});
		
		
		return true;
	}
}
