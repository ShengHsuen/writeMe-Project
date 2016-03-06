package com.mett.writeMe.controllers;

<<<<<<< HEAD
public class WrittingController {

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.services.WrittingServiceInterface;

@RestController

@RequestMapping(value ="/write")

public class WrittingController {
@Autowired private WrittingServiceInterface WrittingService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public WrittingResponse create(@RequestBody WrittingRequest ur){	
		WrittingResponse us = new WrittingResponse();
		Boolean state = WrittingService.saveWritting(ur);		
			if(state){
				us.setCode(200);
				us.setCodeMessage("write created succesfully");
			}
			return us;
	}
>>>>>>> d4826a6b013102cd75ab02efe1bd7f8c1852bd30
}
