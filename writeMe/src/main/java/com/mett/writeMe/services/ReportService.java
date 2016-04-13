package com.mett.writeMe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mett.writeMe.contracts.ReportRequest;
import com.mett.writeMe.ejb.LegalEstablishment;
import com.mett.writeMe.ejb.Report;
import com.mett.writeMe.pojo.ReportPOJO;
import com.mett.writeMe.repositories.LegalEstablishmentRepository;
import com.mett.writeMe.repositories.ReportRepository;

/**
 * @author Mildred Guerra
 * Report Service 
 *
 */
@Service
public class ReportService implements ReportServiceInterface {
	
	@Autowired
	private ReportRepository repotRepository;

	@Override
	public Boolean save(Report report) {
		Report nrepot=repotRepository.save(report);
		return (nrepot == null) ? false : true;
	}

	@Override
	public List<ReportPOJO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReport(int uHwrittingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean editReport(Report uhw) {
		// TODO Auto-generated method stub
		return null;
	}
}
