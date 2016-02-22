package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int subCategoryId;
	private String description;
	private String name;
	private Category category;

	public Subcategory() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSubCategoryId() {
		return this.subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}