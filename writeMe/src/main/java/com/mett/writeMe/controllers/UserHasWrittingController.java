package com.mett.writeMe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;
import com.mett.writeMe.services.WrittingServiceInterface;

/**
 * @author Dani
 * @author Sheng
 */
@RestController
@RequestMapping(value ="rest/protected/userHasWritting")

public class UserHasWrittingController{
	
@Autowired 
private UserHasWrittingServiceInterface userHasWrittingService;
@Autowired
private WrittingServiceInterface WrittingService;
	
	/**
	 * @param ur
	 * @return us
	 */
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UserHasWrittingResponse create(@RequestBody UserHasWrittingRequest ur){	
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		Boolean state = userHasWrittingService.save(ur);
		
			if(state){
				us.setCode(200);
				us.setCodeMessage("write created succesfully");
			}
			return us;
	}
	
	@RequestMapping(value ="/getUHWByWritting", method = RequestMethod.POST)
	public UserHasWrittingResponse getUHWByWritting(@RequestBody WrittingRequest ur){	
		UserHasWrittingResponse uhwR = new UserHasWrittingResponse();
		WrittingPOJO wr = WrittingService.getWrittingByName(ur);
		List <UserHasWrittingPOJO> uhwPOJO = userHasWrittingService.getUHWByWritting(wr);
		uhwR.setUserHasWritting(uhwPOJO);
	    return uhwR;
	}
	
}
