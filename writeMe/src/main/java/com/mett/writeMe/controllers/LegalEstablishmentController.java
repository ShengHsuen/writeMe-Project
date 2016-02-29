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
@RequestMapping(value ="legal")
public class LegalEstablishmentController {
	@Autowired private ServletContext servletContext;
	@Autowired private LegalEstablishmentServiceInterface legalEstablishmentService;
	@Autowired private HttpServletRequest request;
	
//	COMO TIPO ALQUILER
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public LegalEstablishmentResponse getAll(){	
			
		LegalEstablishmentResponse response = new LegalEstablishmentResponse();
		response.setCode(200);
		response.setCodeMessage("users fetch success");
		response.setLegalEstablishmentList(legalEstablishmentService.getAll());
		return response;		
	}
/*
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public LegalEstablishmentResponse getAll(){
		LegalEstablishmentResponse response = new LegalEstablishmentResponse();
		response.setLegalEstablishmentList(LegalEstablishmentService.getAll());
		return response;		
   }
	*/
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public LegalEstablishmentResponse create(
			@RequestParam("part") int part,
			@RequestParam("name") String name,
			@RequestParam("description") String description){	
		
		    LegalEstablishmentResponse legalEstRes = new LegalEstablishmentResponse();
		  
				
				LegalEstablishment legalEst = new LegalEstablishment();
				legalEst.setName(name);
				legalEst.setDescription(description);
				legalEst.setPart(part);
				Boolean state = legalEstablishmentService.addLegalEstablishment(legalEst);
				
				if(state){
					legalEstRes.setCode(200);
					legalEstRes.setCodeMessage("La regla se creó satisfactoriamente");
				}
			
		    return legalEstRes;		
	}
	
	@RequestMapping(value ="/delete", method = RequestMethod.DELETE)
	public void delete(
			@RequestParam("idLegalEstablishment") int idLegalEstablishment){	
		
		    legalEstablishmentService.deleteLegalEstablishment(idLegalEstablishment);
			
	}
}
