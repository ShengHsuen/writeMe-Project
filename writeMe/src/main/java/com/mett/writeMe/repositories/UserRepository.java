package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	User findByMailAndPassword(String mail,String password);
	List<User> findAll();
	List<User> findByNameContaining(String name);
	User save(User user);
}
