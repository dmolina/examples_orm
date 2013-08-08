package org.uca.gii.ebean.dao;
import java.util.List;

import org.uca.gii.ebean.data.Author;
import org.uca.gii.ebean.data.Book;
import org.uca.gii.ebean.data.Category;

public interface ConsultaBD {
	/**
	 * Recover all books
	 * @return books
	 */
	List<Book> getBooks();
	/**
	 * Recover all books by its category
	 * @param category
	 * @return books with that category 
	 */
	List<Book> getBooksByCategory(String category);
	void updateBook(Book libro);
	List<Category> getCategories();
	void insertCategory(Category category);
	void insertCategories(List<Category> category);
}
