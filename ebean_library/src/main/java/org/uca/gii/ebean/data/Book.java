package org.uca.gii.ebean.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.joda.time.LocalDate;

@Entity
public class Book {
	@Id @GeneratedValue
	@Column(name="id")
	private int id;
	@Column(nullable=false)
	private String title;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="publish", joinColumns=@JoinColumn(name="book"),
	      inverseJoinColumns=@JoinColumn(name="author"))
	private List<Author> authors;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="suggestion", 
			  joinColumns=@JoinColumn(name="book"),
		      inverseJoinColumns=@JoinColumn(name="category"))
	private List<Category> categories;
	@Column(name="pages",nullable=true)
	private int pages;
	
	@Column(name="published")
	private LocalDate published;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return authors.get(0);
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "Title: '" +title +"' First Author='" +getAuthor().getName();
	}
	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the published
	 */
	public LocalDate getPublished() {
		return published;
	}
	/**
	 * @param published the published to set
	 */
	public void setPublished(LocalDate published) {
		this.published = published;
	}
	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
}
