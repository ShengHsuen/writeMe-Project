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
import com.mett.writeMe.pojo.LegalEstablishmentPOJO;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.UserHasWrittingRepository;

/**
 * @author Dani
 * @author Sheng
 */
/**
 * @author Mario
 *
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
	@Transactional
	public List<UserHasWrittingPOJO> getAll() {
		List<UserHasWritting> UserHasWrittings =  userHasWrittingRepository.findAll();
		return generateUserHasWrittingDtos(UserHasWrittings);
	}

	@Override
	public void deleteUserHaswritting(int uHwrittingId) {
		// TODO Auto-generated method stub
		userHasWrittingRepository.delete(uHwrittingId);
	}
}
