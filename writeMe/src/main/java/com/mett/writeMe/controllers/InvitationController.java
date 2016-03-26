package com.mett.writeMe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.services.UsersServiceInterface;

/**
 * @author Dani
 */
@RestController

@RequestMapping(value ="rest/protected/invitation")

public class InvitationController {
	@Autowired private UsersServiceInterface usersService;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public UsersResponse getAll() {
		UsersResponse response = new UsersResponse();
		response.setCode(200);
		response.setCodeMessage("Recibe usuarios satisfactoriamente");
		response.setUsers(usersService.getAll());
		return response;
	}

}
