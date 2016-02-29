package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.User;

public interface UsersRepository extends CrudRepository<User,Integer> {
	User save(User user);
}
