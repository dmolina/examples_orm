package org.uca.gii.mybatis.data;

import java.util.List;

public class Book {
	private String title;
	private Author author;
	private List<Category> categories;
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
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		StringBuilder categories_str = new StringBuilder();
		
		for (Category cat: categories) {
			categories_str.append(cat.getDescription()+ "> " +cat.getMinimum_age());
		}
		return "Title: '" +title +"' Author='" +author.getName() +" Categories: " +categories_str.toString();
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
}
