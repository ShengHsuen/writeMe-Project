package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	User findByMailAndPassword(String mail,String password);
	List<User> findAll();
	List<User> findByNameContaining(String name);
<<<<<<< HEAD
	User save(User user);
=======
>>>>>>> 9de0b37c53a680e34a86b0a6acc5243a3d1e6f37
}
