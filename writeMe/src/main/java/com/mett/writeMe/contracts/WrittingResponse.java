package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.UserHasWrittingPOJO;
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.pojo.WrittingPOJO;

/**
 * @author Sheng hsuen
 *
 */
public class WrittingResponse extends BaseResponse{
	private List<WrittingPOJO> writting;
	private List<UserPOJO> user;
	private List<String> owner;
	public List<String> getOwner() {
		return owner;
	}

	public void setOwner(List<String> owner) {
		this.owner = owner;
	}

	public List<UserPOJO> getUser() {
		return user;
	}

	public void setUser(List<UserPOJO> user) {
		this.user = user;
	}

	private List<UserHasWrittingPOJO> userHasWritting;
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
	
	public List<UserHasWrittingPOJO> getUserHasWritting() {
		return userHasWritting;
	}

	public void setUsuarios(List<UserHasWrittingPOJO> userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}
