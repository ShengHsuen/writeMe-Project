package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.UserHasWritting;


public interface UserHasWrittingRepository extends CrudRepository<UserHasWritting,Integer>{
	UserHasWritting save(UserHasWritting userHasWritting);
	List<UserHasWritting> findAll();
	//List<UserHasWritting> findByNameAndUser(int name, int user);
}
