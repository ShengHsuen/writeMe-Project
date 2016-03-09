package com.mett.writeMe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;

@RestController
@RequestMapping(value ="/userHasWritting")

public class UserHasWrittingController{
	
@Autowired private UserHasWrittingServiceInterface userHasWrittingService;
	
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
}
