package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;
	private int reportId;
	private String comment;
	private String penalty;
	private Typereport typereport;
	private UserHasWritting userHasWritting;

	public Report() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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


	//bi-directional many-to-one association to Typereport
	@ManyToOne
	public Typereport getTypereport() {
		return this.typereport;
	}

	public void setTypereport(Typereport typereport) {
		this.typereport = typereport;
	}


	//bi-directional many-to-one association to UserHasWritting
	@ManyToOne
	@JoinColumn(name="user_has_writting_user_has_writtingId")
	public UserHasWritting getUserHasWritting() {
		return this.userHasWritting;
	}

	public void setUserHasWritting(UserHasWritting userHasWritting) {
		this.userHasWritting = userHasWritting;
	}

}