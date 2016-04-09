package com.mett.writeMe.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UserHasWrittingRequest;
import com.mett.writeMe.contracts.UserHasWrittingResponse;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.UserHasWrittingRepository;
import com.mett.writeMe.repositories.UserRepository;
import com.mett.writeMe.services.LoginServiceInterface;
import com.mett.writeMe.services.UserHasWrittingServiceInterface;
import com.mett.writeMe.services.UsersServiceInterface;
import com.mett.writeMe.services.WrittingService;
import com.mett.writeMe.services.WrittingServiceInterface;

@RestController

@RequestMapping(value ="rest/protected/public")

public class publicController {
	@Autowired private UsersServiceInterface usersService;
	@Autowired private UserHasWrittingServiceInterface userHasWrittingService;
	@Autowired private WrittingServiceInterface writtingService;
	@Autowired private UserRepository userRepository;
	@Autowired private UserHasWrittingRepository userHasWrittingRepository;
	@Autowired private LoginServiceInterface LoginService;
	@RequestMapping(value = "/createPublic", method = RequestMethod.POST)
	public UserHasWrittingResponse createPublic(@RequestBody UserHasWrittingRequest uhw) {
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		Boolean state = false;
		state = userHasWrittingService.addPublic(uhw);
		return us;
	}
	
	@RequestMapping(value = "/getOwnerList", method = RequestMethod.POST)
	public WrittingResponse getOwnerList(@RequestBody UserHasWrittingRequest uhw) {
		//HttpSession currentSession = LoginService.getCurrentSession();
		WrittingResponse response = new WrittingResponse();
		List<Boolean> isOwnerList = new ArrayList<Boolean>();
		//List<WrittingPOJO> wPojo = new ArrayList<WrittingPOJO>();
		List<UserHasWritting> uhww = new ArrayList<UserHasWritting>();
		int idUser = userRepository.findByAuthorContaining(uhw.getSearchTerm()).get(0).getUserId();
		uhww = userHasWrittingRepository.findAllByIdOwnerAndPubliccTrue(idUser);

		for (int i = 0; i < uhww.size(); i++) {
				//Writting wr = new Writting();
				//BeanUtils.copyProperties(wPojo.get(i), wr);
				//isOwnerList.add(WrittingService.getOwner(ur.getSearchTerm(), wr));
			if(uhww.get(i).getOwner() == true){
				isOwnerList.add(true);
			}else{
				isOwnerList.add(false);
			}
		}
		response.setIsOwnerList(isOwnerList);
		return response;
	}
}
