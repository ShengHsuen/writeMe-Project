package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.ejb.UserHasWritting;
//
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.WrittingRepository;

@Service
public class WrittingService implements WrittingServiceInterface{
	@Autowired 
	private WrittingRepository writtingRepository;	

	@Override
	@Transactional
	public List<WrittingPOJO> getAll(WrittingRequest ur) {
		List<Writting> Writtings =  writtingRepository.findAll();
		return generateWrittingDtos(Writtings);
	}
	
	@Override
	@Transactional
	public List<WrittingPOJO> getAllByName(WrittingRequest ur) {
		  List<Writting> Writtings =  writtingRepository.findByNameContaining(ur.getSearchTerm());
		  return generateWrittingDtos(Writtings);
	}
	
	@Override
	@Transactional
	public WrittingPOJO getUserByName(WrittingRequest ur) {
		  List<Writting> Writtings =  writtingRepository.findByNameContaining(ur.getSearchTerm());
		  System.out.println("La obra: "+ Writtings.get(0));
		  return generateWrittingDtos(Writtings).get(0);
	}
	
	/*@Override
	@Transactional
	public String getWrittingContent(WrittingRequest ur) {
		  List<Writting> Writtings =  writtingRepository.findByNameContaining(ur.getSearchTerm());
		  return generateWrittingDtos(Writtings).get(0).getContent();
	}*/
	
	private List<WrittingPOJO> generateWrittingDtos(List<Writting> Writtings){
		List<WrittingPOJO> uiWrittings = new ArrayList<WrittingPOJO>();
		Writtings.stream().forEach(u -> {
			WrittingPOJO dto = new WrittingPOJO();
			BeanUtils.copyProperties(u,dto);
			uiWrittings.add(dto);
		});	
		return uiWrittings;
	}
	
	@Override
	@Transactional
	public Boolean saveWritting(WrittingRequest ur) {
		Writting writting = new Writting();
		UserHasWritting UHW = new UserHasWritting();
		
		BeanUtils.copyProperties(ur.getWritting(), writting);

		Writting nWritting = writtingRepository.save(writting);
		
		return (nWritting == null) ? false : true;
	}
}
