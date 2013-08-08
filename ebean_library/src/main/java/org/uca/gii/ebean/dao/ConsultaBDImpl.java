package org.uca.gii.ebean.dao;

import java.util.List;

import org.uca.gii.ebean.data.Book;
import org.uca.gii.ebean.data.Category;

import com.avaje.ebean.Ebean;

public class ConsultaBDImpl implements ConsultaBD {

	public List<Book> getBooks() {
		return Ebean.find(Book.class).findList();
	}

	public List<Book> getBooksByCategory(String category_str) {
		return Ebean.find(Book.class).where().eq("categories.descripcion", category_str).findList();
//      Long version		
//		Category category = Ebean.find(Category.class).where().eq("description", category_str).findUnique();
//		if (category == null) {
//			return Lists.newLinkedList();
//		}
//		else {
//			return Ebean.find(Book.class).fetch("categories").where().eq("categories.id", category.getId()).findList();
//		}
	}

	public void updateBook(Book libro) {
		Ebean.save(libro);
	}

	public List<Category> getCategories() {
		return Ebean.find(Category.class).findList();
	}

	public void insertCategory(Category category) {
		Ebean.save(category);
	}

	public void insertCategories(List<Category> categories) {

		for (Category category : categories) {
			Ebean.save(category);
		}
	}

}
