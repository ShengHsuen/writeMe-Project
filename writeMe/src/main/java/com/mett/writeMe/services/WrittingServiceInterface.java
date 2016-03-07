package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;

public interface WrittingServiceInterface {

	List<WrittingPOJO> getAll();

	Boolean addWritting(Writting writting);

	Writting getWrittingById(int idWritting);

}
