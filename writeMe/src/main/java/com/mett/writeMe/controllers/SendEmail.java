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
import com.mett.writeMe.services.EmailSenderService;
import com.mett.writeMe.services.LoginServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/resetPassword")
public class SendEmail {
	
	@Autowired private LoginServiceInterface loginService;

	String from = "writeme.mett@gmail.com";
	@RequestMapping(value = "/email", method = RequestMethod.POST)
	@Transactional
		
	public void email(@RequestBody LoginRequest lr){		
	
		LoginResponse response = new LoginResponse();
			        String to = lr.getEmail();
			        String subject = "Solicitud de contraseña ";
			        String message = "La contraseña de su cuenta en Write Me es "+ lr.getPassword();
			        System.out.println(message);
			        EmailSenderService sendMail = new EmailSenderService(from, to, subject, message);
			        sendMail.send();
			
	}

	@RequestMapping(value = "/confCuenta", method = RequestMethod.POST)
	@Transactional
		
	public void confCuenta(@RequestBody LoginRequest lr){		
	
		LoginResponse response = new LoginResponse();
			        String to = lr.getEmail();
			        String subject = "Confirmación de cuenta en Write Me";
			        String message = "Bienvenid@ a la familia Write Me! Gracias por preferir los servicios de Write Me! "+ "Su información de cuenta es: Correo"+ lr.getEmail()+" y contraseña "+ lr.getPassword();
			        System.out.println(message);
			        EmailSenderService sendMail = new EmailSenderService(from, to, subject, message);
			        sendMail.send();
			
	}
}


