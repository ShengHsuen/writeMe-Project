package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.WrittingRequest;
import com.mett.writeMe.contracts.WrittingResponse;
import com.mett.writeMe.ejb.Writting;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;

/**
 * @author Sheng hsuen
 *
 */
public interface WrittingServiceInterface {
	List<WrittingPOJO> getAll(WrittingRequest ur);
	List<WrittingPOJO> getAllByName(WrittingRequest ur);
	Boolean saveWritting(WrittingRequest ur);
	WrittingPOJO getWrittingByName(WrittingRequest ur);
	//String getWrittingContent(WrittingRequest ur);
	Boolean editWritting(Writting writting);
	List<WrittingPOJO> getAll();
	void deletewritting(int writtingId);
	Boolean editWrittingInvitation(WrittingRequest ur);
	List<WrittingPOJO> getPublished(WrittingRequest ur);
	List<UserPOJO> getUsersPublished();
	String getWrittingContent(WrittingRequest ur);
	List<UserPOJO> getUsersByWritting(WrittingRequest ur);
	
}
