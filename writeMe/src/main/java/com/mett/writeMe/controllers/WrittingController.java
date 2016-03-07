package com.mett.writeMe.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.Category;
import com.mett.writeMe.ejb.Record;
import com.mett.writeMe.ejb.Typewritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.services.WrittingServiceInterface;


@RestController
@RequestMapping(value ="/writting")
public class WrittingController {
	@Autowired private WrittingServiceInterface writtingService;
	
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public WrittingResponse getAll(){
	WrittingResponse response = new WrittingResponse();
	response.setWrittingList(writtingService.getAll());
	return response;		
   }
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public WrittingResponse writtingCreate(@RequestParam("writtingId") int writtingId,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("cantUsers") Long cantUsers,
			@RequestParam("numMaxCharacters") Long numMaxCharacters,
			@RequestParam("numMinCharacters") Long numMinCharacters,
			@RequestParam("limitTime") Date limitTime,
			@RequestParam("participation") boolean participation,
			@RequestParam("date") Date date,
			@RequestParam("likes") Long likes,
			@RequestParam("published") boolean published,
			@RequestParam("record") Record record,
			@RequestParam("category") Category category,
			@RequestParam("typeWritting") Typewritting typeWritting,
	        @RequestParam("writting") Writting writtingFather)
	{
		WrittingResponse wr = new WrittingResponse();
		Writting writting = new Writting();
		
		writting.setWrittingId(writtingId);
		writting.setName(name);
		writting.setDescription(description);
		writting.setCantUsers(cantUsers);
		writting.setNumMaxCharacters(numMaxCharacters);
		writting.setNumMinCharacters(numMinCharacters);
		writting.setLimitTime(limitTime);
		writting.setParticipation(participation);
		writting.setDate(date);
		writting.setLikes(likes);
		writting.setPublished(published);
		writting.setRecord(record);
		writting.setCategory(category);
		writting.setTypewritting(typeWritting);
		writting.addWritting(writtingFather);

		writtingService.addWritting(writting);
		
		return wr;
		
	}
}
