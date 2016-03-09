package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.WrittingPOJO;

/**
 * @author Sheng hsuen
 *
 */
public class WrittingResponse extends BaseResponse{
	private List<WrittingPOJO> writting;
	private int idWritting;
	private String name;
	
	public int getIdWritting() {
		return idWritting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIdWritting(int idWritting) {
		this.idWritting = idWritting;
	}

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
