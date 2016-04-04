package com.mett.writeMe.contracts;

import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;

/**
 * @author Sheng hsuen
 *
 */
public class WrittingRequest extends BaseRequest {
	
	private WrittingPOJO writting;
	private UserPOJO user;
	
	public UserPOJO getUser() {
		return user;
	}

	public void setUser(UserPOJO user) {
		this.user = user;
	}

	public WrittingRequest() {
		super();
	}
	
	public WrittingPOJO getWritting() {
		return writting;
	}
	
	public void setWritting(WrittingPOJO writting) {
		this.writting = writting;
	}

	@Override
	public String toString() {
		return "WrittingRequest [writting=" + writting + "]";
	}
}
