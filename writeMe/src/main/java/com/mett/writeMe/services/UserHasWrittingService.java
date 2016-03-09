package com.mett.writeMe.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.ejb.UserHasWritting;
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
	
}
