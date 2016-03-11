package com.mett.writeMe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.UserHasWritting;

public interface UserHasWrittingRepository extends CrudRepository<UserHasWritting,Integer>{
	UserHasWritting save(UserHasWritting userHasWritting);
}
