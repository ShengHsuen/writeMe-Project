package com.mett.writeMe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.repositories.UserRepository;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;
import com.mett.writeMe.services.UsersServiceInterface;
import com.mett.writeMe.services.WrittingServiceInterface;

/**
 * @author Dani
 */
@RestController

@RequestMapping(value ="rest/protected/invitation")

public class InvitationController {
	@Autowired private UsersServiceInterface usersService;
	@Autowired private UserHasWrittingServiceInterface userHasWrittingService;
	@Autowired private WrittingServiceInterface writtingService;
	@Autowired private UserRepository userRepository;
	private List<User> luser = new ArrayList<User>();
	private Writting wri = new Writting();
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public UsersResponse getAll() {
		UsersResponse response = new UsersResponse();
		response.setCode(200);
		response.setCodeMessage("Recibe usuarios satisfactoriamente");
		response.setUsers(usersService.getAll());
		return response;
	}
	
	@RequestMapping(value = "/sendInvitation", method = RequestMethod.POST)
	public UserHasWrittingResponse sendInvitation(@RequestBody UsersRequest guests) {
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		for(int i=0;i<guests.getLuser().size();i++){
			User dto = new User();
			BeanUtils.copyProperties(guests.getLuser().get(i),dto);
			luser.add(dto);
		}
		System.out.println(luser.get(0).getAuthor());
		return us;
	}
	
	@RequestMapping(value = "/createInvitation", method = RequestMethod.POST)
	public UserHasWrittingResponse createInvitation(@RequestBody UserHasWrittingRequest uhw) {
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		Boolean state = null;
		for(int i=0;i<luser.size();i++){
			uhw.getUserHasWritting().setUser(luser.get(i));
			uhw.getUserHasWritting().setWritting(wri);
			state = userHasWrittingService.save(uhw);
		}
		if (state) {
			us.setCode(200);
			us.setCodeMessage("write created succesfully");
		}	
		return us;
	}
	
	@RequestMapping(value = "/findWritting", method = RequestMethod.POST)
	public WrittingResponse findWritting(@RequestParam("writtingId") int writtingId) {
		WrittingResponse rs = new WrittingResponse();
		Writting wr = writtingService.getWrittingById(writtingId);
		wri = wr;
		return rs;
	}

}