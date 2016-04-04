package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.User;
import com.mett.writeMe.ejb.UserHasWritting;
import com.mett.writeMe.ejb.Writting;

public interface UserHasWrittingRepository extends CrudRepository<UserHasWritting,Integer>{
	UserHasWritting save(UserHasWritting userHasWritting);
	List<UserHasWritting> findAll();
	List<UserHasWritting> findAllByInvitationStatusTrue();
	UserHasWritting findUserHasWrittingByWrittingWrittingIdAndOwnerTrue(int p);
	List<UserHasWritting> findUserHasWrittingByWrittingWrittingIdAndOwnerFalse(int p);
	List<User> findUserByUserUserIdContainingAndWrittingAndOwnerTrue(int p, Writting w);
	List<UserHasWritting> findAllBylinkInvitation(int p);
	UserHasWritting findByUserAndWritting(User u, Writting w);
}
