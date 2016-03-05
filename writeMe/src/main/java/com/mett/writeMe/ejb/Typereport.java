package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typereport database table.
 * 
 */
@Entity
@NamedQuery(name="Typereport.findAll", query="SELECT t FROM Typereport t")
public class Typereport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int typeReportId;

	private String name;

	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="typereport")
	private List<Report> reports;

	public Typereport() {
	}

	public int getTypeReportId() {
		return this.typeReportId;
	}

	public void setTypeReportId(int typeReportId) {
		this.typeReportId = typeReportId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setTypereport(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setTypereport(null);

		return report;
	}

}