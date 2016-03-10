package com.mett.writeMe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.BaseResponse;
import com.mett.writeMe.contracts.LoginRequest;
import com.mett.writeMe.contracts.LoginResponse;
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.contracts.UsersResponse;
import com.mett.writeMe.ejb.User;
import com.mett.writeMe.services.EmailSenderService;
import com.mett.writeMe.services.LoginServiceInterface;
import com.mett.writeMe.services.UsersServiceInterface;


/**
 * Handles requests for the application home page.
 */
/**
 * @author Mildred Guerra
 *
 */
@RestController
@RequestMapping(value = "rest/email")
public class SendEmail {
	
	@Autowired private UsersServiceInterface usersService;

	String from = "writeme.mett@gmail.com";
	/**
	 * Send an email with user's password
	 * @param lr UsersRequest
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@Transactional
		
	public UsersResponse email(@RequestBody UsersRequest userRequest){		
		User user =new User();
		UsersResponse us = new UsersResponse();
		   user =usersService.getUserByMail(userRequest);
		   System.out.println("Se cae aqui"+ user.getMail());
		   String to = user.getMail();
	        String subject = "Solicitud de contraseña ";
	        String message = "La contraseña de su cuenta en Write Me es "+ user.getPassword();
	        EmailSenderService sendMail = new EmailSenderService(from, to, subject, message);
	        sendMail.send();
			if(user != null){
				us.setCode(200);
				us.setCodeMessage("user get succesfully");
			}
			return us;
			      
			
	}

	
	/**
	 * Send an email to confirm the account
	 * @param userRequest
	 */
	@RequestMapping(value = "/confCuenta", method = RequestMethod.POST)
	@Transactional
		
	public UsersResponse confCuenta(@RequestBody UsersRequest userRequest){	
		User user =new User();
		UsersResponse us = new UsersResponse();
		   user =usersService.getUserByMail(userRequest);
		   String to = user.getMail();
	        String subject = "Confirmación de cuenta en Write Me";
	        String message = "Bienvenid@ a la familia Write Me! Gracias por preferir los servicios de Write Me "+user.getName()+ "! Su información de cuenta es: Correo"+ user.getMail()+" y contraseña "+ user.getPassword();
		    EmailSenderService sendMail = new EmailSenderService(from, to, subject, message);
	        sendMail.send();
			if(user != null){
				us.setCode(200);
				us.setCodeMessage("user get succesfully");
			}
			return us;
			
	}
}


