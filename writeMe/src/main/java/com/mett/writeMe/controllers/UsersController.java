package com.mett.writeMe.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.services.UsersServiceInterface;

@RestController
@RequestMapping(value ="users")
public class UsersController {
	@Autowired private UsersServiceInterface usersService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public UsersResponse create(
			@RequestParam("userId") int userId,
			@RequestParam("accountType") boolean accountType,
			@RequestParam("admin") boolean admin,
			@RequestParam("author") String author,
			//@RequestParam("birthDay") Date birthDay,
			@RequestParam("lastName") String lastName,
			@RequestParam("mail") String mail,
			@RequestParam("name") String name,
			@RequestParam("password") String password){	
			
			System.out.println("userId: "+ userId + " author: "+ author);
			
		    UsersResponse us = new UsersResponse();
			User user = new User();
				user.setUserId(1);
				user.setAccountType(accountType);
				user.setAdmin(admin);
				user.setAuthor(author);
				//user.setBirthDay(birthDay);
				user.setLastName(lastName);
				user.setMail(mail);
				user.setName(name);
				user.setPassword(password);
				usersService.addUser(user);
			
			//Boolean state = tipoUsuarioService.addTipoUsuario(tipoUsuario);
		
		    return us;		
	}
}

