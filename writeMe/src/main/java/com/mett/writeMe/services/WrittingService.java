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

/**
 * @author Sheng hsuen
 *
 */
@Service
public class WrittingService implements WrittingServiceInterface{
	@Autowired 
	private WrittingRepository writtingRepository;	

	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#getAll(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public List<WrittingPOJO> getAll(WrittingRequest ur) {
		List<Writting> Writtings =  writtingRepository.findAll();
		return generateWrittingDtos(Writtings);
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#getAllByName(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public List<WrittingPOJO> getAllByName(WrittingRequest ur) {
		  List<Writting> Writtings =  writtingRepository.findByNameContaining(ur.getSearchTerm());
		  return generateWrittingDtos(Writtings);
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#getWrittingByName(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public WrittingPOJO getWrittingByName(WrittingRequest ur) {
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
	
	/**
	 * @param Writtings
	 * @return
	 */
	private List<WrittingPOJO> generateWrittingDtos(List<Writting> Writtings){
		List<WrittingPOJO> uiWrittings = new ArrayList<WrittingPOJO>();
		Writtings.stream().forEach(u -> {
			WrittingPOJO dto = new WrittingPOJO();
			BeanUtils.copyProperties(u,dto);
			uiWrittings.add(dto);
		});	
		return uiWrittings;
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#saveWritting(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public Boolean saveWritting(WrittingRequest ur) {
		Writting writting = new Writting();
		
		BeanUtils.copyProperties(ur.getWritting(), writting);

		Writting nWritting = writtingRepository.save(writting);
		
		return (nWritting == null) ? false : true;
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#editWritting(com.mett.writeMe.ejb.Writting)
	 */
	@Override
	@Transactional
	public Boolean editWritting(Writting writting){
		
		Writting nwritting = writtingRepository.save(writting);
		return (nwritting == null) ? false : true;
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#saveWritting(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public Boolean editWrittingInvitation(WrittingRequest ur) {
		Writting writting = new Writting();
		BeanUtils.copyProperties(ur.getWritting(), writting);
		Writting nWritting = writtingRepository.save(writting);
		
		return (nWritting == null) ? false : true;
	}
	
}
