package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.LegalEstablishmentRequest;
import com.mett.writeMe.ejb.LegalEstablishment;
import com.mett.writeMe.pojo.LegalEstablishmentPOJO;
import com.mett.writeMe.repositories.LegalEstablishmentRepository;
@Service
public class LegalEstablishmentService implements LegalEstablishmentServiceInterface {
	
	@Autowired private LegalEstablishmentRepository legalEstablishmentRepository;
	
	@Override
	@Transactional
	public List<LegalEstablishmentPOJO> getAll() {
		List<LegalEstablishment> tipos = legalEstablishmentRepository.findAll();
		List<LegalEstablishmentPOJO> dtos = new ArrayList<LegalEstablishmentPOJO>();
		tipos.stream().forEach(tu ->{
			LegalEstablishmentPOJO dto = new LegalEstablishmentPOJO();
			BeanUtils.copyProperties(tu, dto);
			dtos.add(dto);
		});
		return dtos;
	}
	
	
	@Override
	public LegalEstablishment getLegalEstablishmentById(int idLegalEstablishment) {
		return legalEstablishmentRepository.findOne(idLegalEstablishment);
	}

	@Override
	public Boolean saveLegalEstablishment(LegalEstablishment ler) {
		//LegalEstablishment legal= new LegalEstablishment();
	//	BeanUtils.copyProperties(ler.getLegalEstablishment(), legal);
		
		LegalEstablishment nlegal= legalEstablishmentRepository.save(ler);
		return (nlegal == null) ? false : true;
	}
	
	@Override
	public void deleteLegalEstablishment(int idLegalEstablishment){
	   legalEstablishmentRepository.delete(idLegalEstablishment);
	}
	
}
	

