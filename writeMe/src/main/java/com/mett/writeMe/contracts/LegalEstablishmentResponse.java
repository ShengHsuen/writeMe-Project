package com.mett.writeMe.contracts;

import java.util.List;

import com.mett.writeMe.pojo.LegalEstablishmentPOJO;
import com.mett.writeMe.contracts.BaseResponse;

public class LegalEstablishmentResponse extends BaseResponse {
	private List<LegalEstablishmentPOJO> legalEstList;

	public LegalEstablishmentResponse() {
		super();
	}

	public List<LegalEstablishmentPOJO> getTipoUsuarioList() {
		return legalEstList;
	}

	public void setLegalEstablishmentList(List<LegalEstablishmentPOJO> legalEstList) {
		this.legalEstList = legalEstList;
	}

	public void setLegalEstablishmentList(Object all) {
		// TODO Auto-generated method stub
		
	}

}