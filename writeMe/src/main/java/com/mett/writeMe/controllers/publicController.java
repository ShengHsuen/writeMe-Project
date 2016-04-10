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
import com.mett.writeMe.repositories.WrittingRepository;
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
	@Autowired private WrittingRepository writtingRepository;
	@Autowired private LoginServiceInterface LoginService;
	
	@RequestMapping(value = "/createPublic", method = RequestMethod.POST)
	public UserHasWrittingResponse createPublic(@RequestBody UserHasWrittingRequest uhw) {
		UserHasWrittingResponse us = new UserHasWrittingResponse();
		Boolean state = false;
		state = userHasWrittingService.addPublic(uhw);
		return us;
	}
	
	@RequestMapping(value = "/getOwnerList", method = RequestMethod.POST)
	public WrittingResponse getOwnerList(@RequestBody UserHasWrittingRequest uhwr) {
		WrittingResponse response = new WrittingResponse();
		List<Boolean> isOwnerList = new ArrayList<Boolean>();
		List<Writting> lw = new ArrayList<Writting>();
		List<UserHasWritting> allUhw = new ArrayList<UserHasWritting>();
		lw.addAll(writtingRepository.findAllByPublishedTrueAndNameNotNull());
		int idUser = userRepository.findByAuthorContaining(uhwr.getSearchTerm()).get(0).getUserId();
		allUhw = userHasWrittingRepository.findAllByUserUserIdAndPubliccTrue(idUser);
		UserHasWritting uhw = new UserHasWritting();
		boolean resul;
		for (int i = 0; i < lw.size(); i++) {
			uhw = userHasWrittingRepository.findUserHasWrittingByWrittingWrittingIdAndUserUserIdAndPubliccTrue(lw.get(i).getWrittingId(),idUser);
			try{
				if(uhw != null){
					System.out.println("ESTE ME TRAE EL OWNER " + uhw.getUser_has_writtingId());
					resul = false;
				}else{
					resul = true;
				}
			}catch(Exception e){
				resul = true;
			}
			isOwnerList.add(resul);
			uhw = new UserHasWritting();
		}
		response.setIsOwnerList(isOwnerList);
		return response;
	}
}
