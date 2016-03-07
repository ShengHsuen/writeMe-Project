package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.WrittingPOJO;

public class WrittingResponse {
	
	private List <WrittingPOJO> writtingList;
	
	public WrittingResponse() {
		super();
	}
	
	public List<WrittingPOJO> getWrittingList() {
		return writtingList;
	}
	public void setWrittingList(List<WrittingPOJO> writtingList) {
		this.writtingList = writtingList;
	}


}
