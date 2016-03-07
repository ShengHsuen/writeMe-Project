package com.mett.writeMe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mett.writeMe.ejb.Writting;


public interface WrittingRepository extends CrudRepository<Writting,Integer>{
     List<Writting> findAll();
}
