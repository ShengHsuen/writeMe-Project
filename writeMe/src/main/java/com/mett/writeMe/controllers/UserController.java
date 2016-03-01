package com.mett.writeMe.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.services.UsersServiceInterface;

@RestController
@RequestMapping(value ="/")
public class UserController {
	@Autowired private UsersServiceInterface usersService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UsersResponse create(@RequestBody UsersRequest ur){	
		UsersResponse us = new UsersResponse();
		Boolean state = usersService.saveUser(ur);
		return us;
		
	}
}

