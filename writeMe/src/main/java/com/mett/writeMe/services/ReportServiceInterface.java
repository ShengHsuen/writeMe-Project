package com.mett.writeMe.services;

import java.util.List;
import com.mett.writeMe.contracts.ReportRequest;
import com.mett.writeMe.ejb.Report;
import com.mett.writeMe.pojo.ReportPOJO;
/**
 * @author Mildred Guerra
 * Report Service Interface 
 *
 */
public interface ReportServiceInterface {
	Boolean save(Report ur);
	void deleteReport(int uHwrittingId);
	List<ReportPOJO> getAll();
	Boolean editReport(Report uhw);
}
