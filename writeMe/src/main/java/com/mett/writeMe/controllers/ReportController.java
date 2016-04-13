package com.mett.writeMe.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mett.writeMe.contracts.ReportResponse;
import com.mett.writeMe.ejb.Report;
import com.mett.writeMe.services.ReportServiceInterface;

/**
 * @author Mildred Guerra
 * Report Controller 
 *
 */
@RestController
@RequestMapping(value ="rest/protected/reportWritting")
public class ReportController {
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ReportServiceInterface ReportService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * This method get all the writtings Reports 
	 * 
	 * @return ReportResponse
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public ReportResponse getAll() {
		ReportResponse response = new ReportResponse();
		response.setCode(200);
		response.setCodeMessage("Muestra deuncias satisfactoriamente");
		response.setReportList(ReportService.getAll());
		return response;
	}

	/**
	 * Create the Report
	 * 
	 * @param ler
	 * @return ReportResponse
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ReportResponse create(@RequestBody Report ler) {
		System.out.println("Entra a controller" + ler);
		ReportResponse reportRes = new ReportResponse();

		Boolean state = ReportService.save(ler);

		if (state) {
			reportRes.setCode(200);
			reportRes.setCodeMessage("La deuncia se creó satisfactoriamente");
		}

		return reportRes;
	}

}
