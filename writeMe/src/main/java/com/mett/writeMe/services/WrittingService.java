package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;
import com.mett.writeMe.repositories.WrittingRepository;


@Service
public class WrittingService implements WrittingServiceInterface {
	@Autowired private WrittingRepository writtingRepository;
	
	@Override
	@Transactional
	public List<WrittingPOJO> getAll() {
		List<Writting> tipos = writtingRepository.findAll();
		List<WrittingPOJO> dtos = new ArrayList<WrittingPOJO>();
		tipos.stream().forEach(tu ->{
			WrittingPOJO dto = new WrittingPOJO();
			BeanUtils.copyProperties(tu, dto);
			dtos.add(dto);
		});
		return dtos;
	}
	
	@Override
	public Boolean addWritting(Writting writting) {
		Writting nwritting= writtingRepository.save(writting);
		return (nwritting == null) ? false : true;
	}
	
	@Override
	public Writting getWrittingById(int idWritting) {
		return writtingRepository.findOne(idWritting);
	}
}
