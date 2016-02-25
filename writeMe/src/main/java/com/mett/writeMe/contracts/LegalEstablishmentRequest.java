package com.mett.writeMe.contracts;

public class LegalEstablishmentRequest {
	private String legalEst;

	public LegalEstablishmentRequest(String legalEst){
		super();
		this.legalEst = legalEst;
	}

	public String getLegalEstablishment(){
		return legalEst;
	}
	public void setLegalEstablishment(String legalEst){
		this.legalEst = legalEst;
	}

}
