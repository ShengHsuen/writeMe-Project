package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.WrittingRequest;
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

	List<WrittingPOJO> getAll();
	List<WrittingPOJO> getPublished(WrittingRequest ur);
	List<UserPOJO> getUsersPublished();
	List<WrittingPOJO> getWrittingsByMainWritting(Writting wr);
	WrittingPOJO getWrittingByName(WrittingRequest ur);
	String getWrittingContent(WrittingRequest ur);
	void deletewritting(int writtingId);
	Boolean saveWritting(WrittingRequest ur);
	Boolean editWritting(Writting wr);
	Boolean editWrittingInvitation(Writting wr);
	Boolean publish(WrittingRequest ur);
	Writting getWrittingById(int idWritting);
}
