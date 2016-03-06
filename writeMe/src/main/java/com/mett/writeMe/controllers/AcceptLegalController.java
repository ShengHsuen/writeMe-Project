package com.mett.writeMe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.LegalEstablishmentResponse;
import com.mett.writeMe.services.LegalEstablishmentServiceInterface;

@RestController
@RequestMapping(value ="acceptLegalEstablishment")
public class AcceptLegalController {
	
		@Autowired private LegalEstablishmentServiceInterface legalEstablishmentService;

		
		@RequestMapping(value ="/getAll", method = RequestMethod.POST)
		public LegalEstablishmentResponse getAll(){	
			LegalEstablishmentResponse response = new LegalEstablishmentResponse();
			response.setCode(200);
			response.setCodeMessage("Muestra reglas satisfactoriamente");
			
			response.setLegalEstablishmentList(legalEstablishmentService.getAll());

			System.out.println("ENTRA AL CONTROLLER2" +response.getlegalList());
			return response;		
		}
	}