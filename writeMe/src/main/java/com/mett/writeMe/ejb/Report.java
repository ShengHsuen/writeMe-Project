package com.mett.writeMe.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reportId;

	private String comment;

	private String penalty;

	//bi-directional many-to-one association to Typereport
	@ManyToOne(fetch=FetchType.LAZY)
	private Typereport typereport;

	//bi-directional many-to-one association to UserHasWritting
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_has_writting_user_has_writtingId")
	private UserHasWritting userHasWritting;

	public Report() {
	}

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPenalty() {
		return this.penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	public Typereport getTypereport() {
		return this.typereport;
	}

	public void setTypereport(Typereport typereport) {
		this.typereport = typereport;
	}

	public UserHasWritting getUserHasWritting() {
		return this.userHasWritting;
	}

	public void setUserHasWritting(UserHasWritting userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}