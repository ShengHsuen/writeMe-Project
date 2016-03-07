package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.WrittingPOJO;

public interface WrittingServiceInterface {
	List<WrittingPOJO> getAll(WrittingRequest ur);
	List<WrittingPOJO> getAllByName(WrittingRequest ur);
	Boolean saveWritting(WrittingRequest ur);
	WrittingPOJO getIdByName(WrittingRequest ur);
}
