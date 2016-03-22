package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.UserHasWrittingRepository;
import com.mett.writeMe.repositories.WrittingRepository;

/**
 * @author Sheng hsuen
 *
 */
@Service
public class WrittingService implements WrittingServiceInterface{
	
	@Autowired 
	private WrittingRepository writtingRepository;
	@Autowired 
	private UserHasWrittingRepository userHasWrittingRepository;	

	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#getAll(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public List<WrittingPOJO> getAll(WrittingRequest ur) {
		List<Writting> Writtings = writtingRepository.findAll();
		return generateWrittingDtos(Writtings);
	}

	/* @author Mildred Guerra
	 * Get the list of all writtings
	 * Return a List<WrittingPOJO>  dtos 
	 */
	@Override
	@Transactional
	public List<WrittingPOJO> getAll() {
		List<Writting> wirttings = writtingRepository.findAll();
		List<WrittingPOJO> dtos = new ArrayList<WrittingPOJO>();
		wirttings.stream().forEach(tu ->{
			WrittingPOJO dto = new WrittingPOJO();
			BeanUtils.copyProperties(tu, dto);
			if( tu.getWritting()!= null){

				dto.setWrittingFather(tu.getWritting().getWrittingId());
			}
			dtos.add(dto);
		});
		return dtos;
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

	@Override
	@Transactional
	public List<WrittingPOJO> getPublished(WrittingRequest ur){
		  System.out.println("Service /getPublished");
		  List<Writting> Writtings =  writtingRepository.findByPublishedTrue();
		  //System.out.println("Service /getPublished : " + Writtings.get(0).getUserHasWrittings().get(0).getUser().getName());
		  return generateWrittingDtos(Writtings);
	}
	
	@Override
	@Transactional
	public List<WrittingPOJO> getWrittingsByMainWritting(Writting wr){
		List<WrittingPOJO> WrittingPOJO = new ArrayList<WrittingPOJO>();
		List<Writting> Writting = writtingRepository.findByNameContaining(wr.getName());
		List<Writting> Writtings = writtingRepository.findAll();
		
		WrittingPOJO dto = new WrittingPOJO();
		BeanUtils.copyProperties(Writting.get(0), dto);
		System.out.print("ESTE ES LA OBRA PROPIETARIO"+Writting.get(0).getName());
		WrittingPOJO.add(dto);
		
		for(int i=0; i <= Writtings.size()-1; i++){
			if(Writtings.get(i).getMainWritting() == Writting.get(0).getWrittingId()){
				BeanUtils.copyProperties(Writtings.get(i), dto);
				WrittingPOJO.add(dto);
				System.out.print("ESTOS SON LOS HIJOS DE UNA OBRA"+ Writtings.get(i).getWrittingId());
			}
		}
		return WrittingPOJO;
	}
	
	// Comentado
	public List<UserPOJO> getUsersPublished(){
		List<UserPOJO> Users = new ArrayList<UserPOJO>();
		/*List<Writting> Writtings =  writtingRepository.findByPublishedTrue();
		List<UserHasWritting> UserHasWrittings = userHasWrittingRepository.findAll();
		System.out.println("Size: "+ Writtings.size());
		int j = 0;
		for(int i=0;i<=UserHasWrittings.size()-1;i++){
			if(Writtings.get(j).getWrittingId() == UserHasWrittings.get(i).getWritting().getWrittingId()){
				j++;
				System.out.println("j "+j);
				UserPOJO dto = new UserPOJO();
				BeanUtils.copyProperties(UserHasWrittings.get(i).getUser(),dto);
				Users.add(dto);
			}else{
				
			}
		}*/
		  return Users;
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


	
	  @Override
	  @Transactional 
	  public String getWrittingContent(WrittingRequest ur) {
      String content ="";
	  Writting writting = writtingRepository.findOne(Integer.parseInt(ur.getSearchTerm()));
	  List<Writting> wri = writtingRepository.findAll();
      int j=0;
      for (int i=0; i<= wri.size() -1; i++){
    	  if(writting.getMainWritting() == wri.get(i).getMainWritting()){
    		  j++;
    		//  content = content + wri.get(i).getContent() ;
    		  content =  wri.get(i).getContent() ;
    		 // System.out.println("Aqui la obra" + content + "\n");
    	  }else{
    		  
    	  }
      }
      return content;
     }


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
		UserHasWritting UHW = new UserHasWritting();
		
		BeanUtils.copyProperties(ur.getWritting(), writting);

		Writting nWritting = writtingRepository.save(writting);
		
		return (nWritting == null) ? false : true;
	}
	
	/* (non-Javadoc)
	 * @see com.mett.writeMe.services.WrittingServiceInterface#editWritting(com.mett.writeMe.ejb.Writting)
	 */
	@Override
	@Transactional
	public Boolean editWritting(Writting wr) {
		Writting nwritting = writtingRepository.save(wr);

		return (nwritting == null) ? false : true;
	}
	
	@Override
	@Transactional
	public Boolean publish(WrittingRequest ur){
		List<Writting> Writtings =  writtingRepository.findByNameContaining(ur.getSearchTerm());
		Writtings.get(0).setPublished(true);
		Writtings.get(0).setDate(ur.getWritting().getDate());
		Writting nwritting = writtingRepository.save(Writtings.get(0));
		return (nwritting == null) ? false : true;
	}

	
	/* @author Mildred Guerra
	 * Delete a writting
	 * @param int writtingId
	 * @see com.mett.writeMe.services.WrittingServiceInterface#editWritting(com.mett.writeMe.ejb.Writting)
	 */
	@Override
	public void deletewritting(int writtingId) {
		writtingRepository.delete(writtingId);
	}

	/* @author Sheng Hsuen Cheng
	 * @see com.mett.writeMe.services.WrittingServiceInterface#editWrittingInvitation(com.mett.writeMe.contracts.WrittingRequest)
	 */
	@Override
	@Transactional
	public Boolean editWrittingInvitation(Writting wr) {
		List<WrittingPOJO> wrPojos = getWrittingsByMainWritting(wr);
		List<Writting> writting = new ArrayList<Writting>();
		WrittingPOJO wrPOJO = new WrittingPOJO();
		BeanUtils.copyProperties(wrPojos, writting);
		int father = 0;
		
		List<UserHasWritting> UserHasWrittings = userHasWrittingRepository.findAll();
		for(int i=0;i<=UserHasWrittings.size()-1;i++){
			if(wr.getWrittingId() == UserHasWrittings.get(i).getWritting().getWrittingId()){
				wr.setWrittingId(0);
				wr.setName(null);
				wr.setMainWritting(UserHasWrittings.get(i).getWritting().getWrittingId());
				System.out.print("ID PARA EL MAIN WRITTING "+UserHasWrittings.get(i).getWritting().getWrittingId());
				
				
//				dto.setWrittingFather(tu.getWritting().getWrittingId());
//				BeanUtils.copyProperties(wr, wrPOJO);
//				wrPOJO.setWrittingFather(writting.get(father));
//				father = wrPojos.get(wrPojos.size()-2);
////				wr.setWritting(writting.get(father));
////				System.out.print("ID DEL PADRE ES:  "+writting.get(father).getWrittingId());
				
			}
		}
		Writting nWritting = writtingRepository.save(wr);

		
		return (nWritting == null) ? false : true;
	}
}
