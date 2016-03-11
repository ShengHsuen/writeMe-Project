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
	public List<UserHasWrittingPOJO> getAllByUser(int idUser) {
		List<UserHasWritting> UserHasWrittings =  userHasWrittingRepository.findAll();
		List<UserHasWrittingPOJO> dtos = new ArrayList<UserHasWrittingPOJO>();
		UserHasWrittings.stream().filter(tu -> tu.getUser().getUserId() == idUser).forEach(tu ->{
			UserHasWrittingPOJO dto = new UserHasWrittingPOJO();
			BeanUtils.copyProperties(tu, dto);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public List<UserHasWrittingPOJO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
	
}
