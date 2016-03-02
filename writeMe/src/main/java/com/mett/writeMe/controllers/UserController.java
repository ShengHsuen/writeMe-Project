package com.mett.writeMe.controllers;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;

=======
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.services.UsersServiceInterface;

@RestController
<<<<<<< HEAD
@RequestMapping(value ="/")
=======
@RequestMapping(value ="users")
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
public class UserController {
	@Autowired private UsersServiceInterface usersService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UsersResponse create(@RequestBody UsersRequest ur){	
<<<<<<< HEAD
		UsersResponse us = new UsersResponse();
		Boolean state = usersService.saveUser(ur);
		return us;
		
=======
			
			System.out.println("Entre al controlador");
			System.out.println(ur);
			
			UsersResponse us = new UsersResponse();
			Boolean state = usersService.saveUser(ur);
		
			if(state){
				us.setCode(200);
				us.setCodeMessage("user created succesfully");
			}
			return us;
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
	}
}

