package com.mett.writeMe.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Subcategory
	@OneToMany(mappedBy="category")
	private List<Subcategory> subcategories;

	//bi-directional many-to-one association to Writting
	@OneToMany(mappedBy="category")
	private List<Writting> writtings;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public List<Subcategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Subcategory addSubcategory(Subcategory subcategory) {
		getSubcategories().add(subcategory);
		subcategory.setCategory(this);

		return subcategory;
	}

	public Subcategory removeSubcategory(Subcategory subcategory) {
		getSubcategories().remove(subcategory);
		subcategory.setCategory(null);

		return subcategory;
	}

	public List<Writting> getWrittings() {
		return this.writtings;
	}

	public void setWrittings(List<Writting> writtings) {
		this.writtings = writtings;
	}

	public Writting addWritting(Writting writting) {
		getWrittings().add(writting);
		writting.setCategory(this);

		return writting;
	}

	public Writting removeWritting(Writting writting) {
		getWrittings().remove(writting);
		writting.setCategory(null);

		return writting;
	}

}