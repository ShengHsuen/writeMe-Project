package com.mett.writeMe.controllers;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mett.writeMe.contracts.LegalEstablishmentResponse;
import com.mett.writeMe.ejb.LegalEstablishment;
import com.mett.writeMe.services.LegalEstablishmentServiceInterface;
import com.mett.writeMe.utils.Utils;

@RestController
@RequestMapping(value ="rest/protected/LegalEstablishment")
public class LegalEstablishmentController {
	@Autowired private ServletContext servletContext;
	@Autowired private LegalEstablishmentServiceInterface LegalEstablishmentService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public LegalEstablishmentResponse getAll(){
		LegalEstablishmentResponse response = new LegalEstablishmentResponse();
		response.setLegalEstablishmentList(LegalEstablishmentService.getAll());
		return response;		
   }
	
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public LegalEstablishmentResponse create(
			@RequestParam("idLegalEstablishment") int idLegalEstablishment,
			@RequestParam("tipo") String tipo){	
		
		    LegalEstablishmentResponse us = new LegalEstablishmentResponse();
			LegalEstablishment LegalEstablishment = new LegalEstablishment();
			
		    return us;		
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.DELETE)
	public void delete(
			@RequestParam("idLegalEstablishment") int idLegalEstablishment){	
		
		    LegalEstablishmentService.deleteLegalEstablishment(idLegalEstablishment);
			
	}
}
