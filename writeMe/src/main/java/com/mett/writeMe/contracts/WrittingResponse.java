package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.WrittingPOJO;

public class WrittingResponse extends BaseResponse{
	private List<WrittingPOJO> writting;

	public WrittingResponse() {
		super();
	}
	
	public List<WrittingPOJO> getWritting() {
		return writting;
	}

	public void setWritting(List<WrittingPOJO> writting) {
		this.writting = writting;
	}
}
