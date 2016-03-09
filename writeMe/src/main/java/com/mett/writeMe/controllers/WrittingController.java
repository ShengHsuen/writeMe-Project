package com.mett.writeMe.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.services.LoginServiceInterface;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;
import com.mett.writeMe.services.WrittingServiceInterface;

@RestController

@RequestMapping(value ="/writting")

public class WrittingController{
@Autowired private WrittingServiceInterface WrittingService;
@Autowired private UserHasWrittingServiceInterface UserHasWrittingService;
@Autowired private LoginServiceInterface LoginService;
private User u = new User();
private Writting wr = new Writting();
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public WrittingResponse create(@RequestBody WrittingRequest ur){	
		WrittingResponse us = new WrittingResponse();
		
		Boolean state = false;
		
		if(wr.getWrittingId() == wr.getWrittingId()){
			WrittingPOJO w = WrittingService.getWrittingByName(ur);
			BeanUtils.copyProperties(w,wr);
			wr.setContent(ur.getWritting().getContent());
		    state = WrittingService.editWritting(wr);
		}else{
		    WrittingPOJO w = WrittingService.getWrittingByName(ur);
			u = LoginService.getUser();
			BeanUtils.copyProperties(w,wr);
			state = WrittingService.saveWritting(ur);
			
			System.out.println("Writting: "+wr.getWrittingId());
			System.out.println("User"+u.getName());
			
		}
		
			if(state){
				us.setCode(200);
				us.setCodeMessage("write created succesfully");
			}
			return us;
	}
	
	@RequestMapping(value ="/createUserHasWritting", method = RequestMethod.POST)
	public UserHasWrittingResponse create(@RequestBody UserHasWrittingRequest ur){	
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		ur.getUserHasWritting().setUser(u);
		ur.getUserHasWritting().setWritting(wr);
		System.out.println("Obra a la que estoy seteando: "+ur.getUserHasWritting().getWritting().getName());
		Boolean state = UserHasWrittingService.save(ur);
		
			if(state){
				us.setCode(200);
				us.setCodeMessage("write created succesfully");
			}
			return us;
	}
	
	/*@RequestMapping(value="/getWrittingContent", method = RequestMethod.POST)
	public String getWrittingContent(@RequestBody WrittingRequest ur){
		
		WrittingResponse us = new WrittingResponse();
		us.setCode(200);
		us.setCodeMessage("getting content success");
		String content = WrittingService.getWrittingContent(ur);
		System.out.println("the content is:  "+content);
		return content;
		
	}*/
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public WrittingResponse getAll(@RequestBody WrittingRequest ur){	
			
		WrittingResponse us = new WrittingResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setWritting(WrittingService.getAll(ur));
		return us;		
	}
	
	@RequestMapping(value ="/getAllByName", method = RequestMethod.POST)
	public WrittingResponse getAllByName(@RequestBody WrittingRequest ur){	
			
		WrittingResponse us = new WrittingResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setWritting(WrittingService.getAllByName(ur));
		return us;		
	}
	
}
