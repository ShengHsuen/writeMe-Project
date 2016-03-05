package com.mett.writeMe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mett.writeMe.contracts.MyLibraryRequest;
import com.mett.writeMe.ejb.Mylibrary;
import com.mett.writeMe.pojo.MyLibraryPOJO;
import com.mett.writeMe.repositories.MyLibraryRepository;

@Service
public class MyLibraryService implements MyLibraryServiceInterface{
	@Autowired 
	private MyLibraryRepository myLibraryRepository;	

	@Override
	@Transactional
	public List<MyLibraryPOJO> getAll(MyLibraryRequest ur) {
		List<Mylibrary> MyLibraries =  myLibraryRepository.findAll();
		return generateLibraryDtos(MyLibraries);
	}
	
	@Override
	@Transactional
	public List<MyLibraryPOJO> getAllByTitle(MyLibraryRequest ur) {
		List<Mylibrary> MyLibraries =  myLibraryRepository.findByTitleContaining(ur.getSearchTerm());
		return generateLibraryDtos(MyLibraries);
	}
	
	private List<MyLibraryPOJO> generateLibraryDtos(List<Mylibrary> MyLibraries){
		List<MyLibraryPOJO> uiMyLibraries = new ArrayList<MyLibraryPOJO>();
		MyLibraries.stream().forEach(u -> {
			MyLibraryPOJO dto = new MyLibraryPOJO();
			BeanUtils.copyProperties(u,dto);
			uiMyLibraries.add(dto);
		});	
		return uiMyLibraries;
	}
	
	@Override
	@Transactional
	public Boolean saveLibrary(MyLibraryRequest ur) {
		Mylibrary library = new Mylibrary();
		BeanUtils.copyProperties(ur.getLibrary(), library);

		Mylibrary nLibrary = myLibraryRepository.save(library);
		
		return (nLibrary == null) ? false : true;
	}
}
