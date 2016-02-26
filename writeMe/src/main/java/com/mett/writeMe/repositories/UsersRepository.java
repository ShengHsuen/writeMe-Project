package com.mett.writeMe.repositories;

import java.util.List;

import com.mett.writeMe.ejb.User;

public interface UsersRepository {
	User findByEmailAndPassword(String email,String password);
	List<User> findAll();
	List<User> findByFirstnameContaining(String name);
	User save(User user);
	
}
