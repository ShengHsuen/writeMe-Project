package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;

public interface UserHasWrittingRepository extends CrudRepository<UserHasWritting,Integer>{
	UserHasWritting save(UserHasWritting userHasWritting);
	List<UserHasWritting> findAll();
	List<UserHasWritting> findAllByOwnerTrue();
	List<UserHasWritting> findAllBylinkInvitation(int p);
}
