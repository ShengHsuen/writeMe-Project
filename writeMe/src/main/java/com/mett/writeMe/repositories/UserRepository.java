package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	User findByMailAndPassword(String mail,String password);
	List<User> findAll();
	List<User> findByNameContaining(String name);
<<<<<<< HEAD
=======
	User save(User user);
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
}
