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

	@EmbeddedId
	private ReportPK id;

	private String comment;

	private String penalty;

	private String typeReport;

	//bi-directional many-to-one association to Writting
	@ManyToOne(fetch=FetchType.LAZY)
	private Writting writting;

	public Report() {
	}

	public ReportPK getId() {
		return this.id;
	}

	public void setId(ReportPK id) {
		this.id = id;
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

	public String getTypeReport() {
		return this.typeReport;
	}

	public void setTypeReport(String typeReport) {
		this.typeReport = typeReport;
	}

	public Writting getWritting() {
		return this.writting;
	}

	public void setWritting(Writting writting) {
		this.writting = writting;
	}

}