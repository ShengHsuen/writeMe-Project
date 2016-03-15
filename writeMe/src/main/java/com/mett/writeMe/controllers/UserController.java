package com.mett.writeMe.controllers;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.services.UsersServiceInterface;

/**
 * @author Dani
 */
@RestController

@RequestMapping(value ="/users")

public class UserController {
	@Autowired private UsersServiceInterface usersService;
	@Autowired private HttpServletRequest request;
	
	/**
	 * @param ur
	 * @return
	 */
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UsersResponse create(@RequestBody UsersRequest ur){	
		UsersResponse us = new UsersResponse();
		Boolean state = usersService.saveUser(ur);
		//System.out.println("user has w: "+us.getUserHasWritting().get(0).getUser().getName());
			if(state){
				us.setCode(200);
				us.setCodeMessage("user created succesfully");
			}
			return us;
	}
	
	@RequestMapping(value ="/edit", method = RequestMethod.POST)
	public UsersResponse edit(@RequestBody UsersRequest ur){	
		UsersResponse us = new UsersResponse();
		Boolean state = usersService.saveUser(ur);		
			if(state){
				us.setCode(200);
				us.setCodeMessage("user created succesfully");
			}
			return us;
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.DELETE)
	public void delete(
			@RequestParam("idUser") int idUser){	
		    usersService.deleteUser(idUser);
			
	}
	
	@RequestMapping(value ="/getWrittings", method = RequestMethod.POST)
	public UsersResponse getWrittings(@RequestBody UsersRequest ur){	

		UsersResponse response = new UsersResponse();
		response.setCode(200);
		response.setCodeMessage("obtiene bien los writtings");
		response.setWritting(usersService.getWrittingsByUser(ur));
		return response;		
	}
	
	@RequestMapping(value ="/getAll", method = RequestMethod.POST)
	public UsersResponse getAll(@RequestBody UsersRequest ur){	
		UsersResponse us = new UsersResponse();
		us.setCode(200);
		us.setCodeMessage("users fetch success");
		us.setUsers(usersService.getAll(ur));
		return us;		
	}
	
}

