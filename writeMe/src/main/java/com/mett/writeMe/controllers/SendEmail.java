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
		   System.out.println("Entra aqui"+ user.getMail());
		   String to = user.getMail();
	        String subject = "Solicitud de contraseña de WriteMe";
	        String message = "<table class='ecxcontainer' align='center' bgcolor='#e0ddd6' border='0' cellpadding='0' cellspacing='0' width='600'> <tbody><tr> <td class='ecxleftSpace' width='15'></td> <td> <table class='ecxmain' style='border-top-left-radius:4px;border-top-right-radius:4px;' align='center' bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' width='570'> <tbody><tr> <td class='ecxlogoTd' style='padding:30px 0px 20px 0px;' align='center' valign='middle'> <a href='http://localhost:8080/writeMe/#/signin?lnktrk=EMP&amp;g=6B6FE201FA5D6116E870412436AB47A764529820&amp;lkid=URL_HOME' target='_blank'> <h1 style='display:block;font-family:Helvetica, Arial, sans-serif;color:#3A3F51;'>WriteMe</h1> </a> </td> </tr> </tbody></table> <table class='ecxcopy' align='center' bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' width='570'> <tbody><tr> <td class='ecxmobileHeadline' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:20px;font-weight:normal;line-height:24px;padding:0px 34px 25px 34px;' align='center'>Solicitud de contraseña de WriteMe</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>Hola, " + user.getName() + ":</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>Tu contraseña de &nbsp;<a href='http://localhost:8080/writeMe/#/signin/&amp' style='color:#E50914 !important;' target='_blank'>Write Me</a>. es: "+user.getPassword()+" . </td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>¿No solicitaste la contraseña? Entonces ignora este email. </td> </tr> </tbody></table> </td> <td class='ecxrightSpace' width='15'></td> </tr> </tbody></table>";
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
	        String message = "<table class='ecxcontainer' align='center' bgcolor='#e0ddd6' border='0' cellpadding='0' cellspacing='0' width='600'> <tbody><tr> <td class='ecxleftSpace' width='15'></td> <td> <table class='ecxmain' style='border-top-left-radius:4px;border-top-right-radius:4px;' align='center' bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' width='570'> <tbody><tr> <td class='ecxlogoTd' style='padding:30px 0px 20px 0px;' align='center' valign='middle'> <a href='http://localhost:8080/writeMe/#/signin?mqso=80034885&amp;lnktrk=EMP&amp;g=7B1DA67F9800A016D75DD640F33974D664528CF6&amp;lkid=netflixLogo&amp;action=home' target='_blank'> <h1 style='display:block;font-family:Helvetica, Arial, sans-serif;color:#3A3F51;'>WriteMe</h1> </a> </td> </tr> </tbody></table> <table class='ecxcopy' align='center' bgcolor='#ffffff' border='0' cellpadding='0' cellspacing='0' width='570'> <tbody><tr> <td class='ecxmobileHeadline' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:20px;font-weight:normal;line-height:24px;padding:0px 34px 25px 34px;' align='center'>¡Te damos la bienvenida!</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>Hola,"+ user.getName() + ":</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>¡Gracias por suscribirte a WriteMe! Has completado tu suscripción y ya puedes&nbsp;<a href='http://localhost:8080/writeMe/#/signin?mqso=80034885&amp;lnktrk=EMP&amp;g=7B1DA67F9800A016D75DD640F33974D664528CF6&amp;lkid=link1' style='color:#E50914 !important;' target='_blank'>&nbsp;comenzar a disfrutar de obras favoritas</a>.</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;line-height:20px;font-weight:lighter;padding:0px 34px 0px 34px;font-weight:bold;'>Información de tu cuenta:</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;line-height:20px;font-weight:lighter;padding:0px 34px 0px 34px;'> Tu email de inicio de sesión:&nbsp;" + user.getMail() + "</td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;line-height:20px;font-weight:lighter;padding:0px 34px 0px 34px;'> Nombre de usuario: "+user.getAuthor()+" </td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;line-height:20px;font-weight:lighter;padding:0px 34px 0px 34px;'> Contraseña: "+ user.getPassword() + " </td> </tr> <tr> <td class='ecxmobileCopy' style='font-family:Helvetica, Arial, sans-serif;color:#2b2b2b;font-size:14px;padding:0px 34px 25px 34px;line-height:20px;font-weight:lighter;'>¡Que lo disfrutes!</td> </tr> </tbody></table> </td> <td class='ecxrightSpace' width='15'></td> </tr> </tbody></table>";
		    EmailSenderService sendMail = new EmailSenderService(from, to, subject, message);
	        sendMail.send();
			if(user != null){
				us.setCode(200);
				us.setCodeMessage("user get succesfully");
			}
			return us;
			
	}
}


