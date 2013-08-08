package org.uca.gii.ebean.persistence;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.junit.Before;
import org.junit.Test;

import org.uca.gii.ebean.dao.ConsultaBD;
import org.uca.gii.ebean.data.Book;
import org.uca.gii.ebean.data.Category;
import org.uca.gii.ebean.data.Category;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

public class TestBooks extends TestBD {
	@Test
	public void testNotEmpty() {
		List<Book> books = persistence.getBooks();
		Logger log = LoggerFactory.getLogger(TestBooks.class);
		
		for (Book book : books) {
			String name = book.toString();
			log.info(name);			
			
			for (Category category: book.getCategories()) {
				log.info(category.toString());
			}
		}
		assertFalse(books.isEmpty());
	}
	
	@Test
	public void testCategories() {
		List<Book> books = persistence.getBooks();
		
		for (Book book : books) {
			assertNotNull(book.getCategories());
			assertFalse(book.getCategories().isEmpty());
		}
		
		assertTrue(books.size()==2);
	}

	@Test
	public void testDate() {
		List<Book> books = persistence.getBooks();
		
		for (Book book : books) {
			assertNotNull(book.getPublished());
		}
	}
	
	@Test
	public void testFindByCategory(){
		List<Book> books;
		
		books = persistence.getBooksByCategory("Ensayo");
		assertTrue(books.size()==1);
		assertTrue(books.get(0).getTitle().equalsIgnoreCase("no logo"));
		books = persistence.getBooksByCategory("Nulo");
		assertTrue(books.isEmpty());
	}
	
	class FindByTitle implements Predicate<Book> {
		private String title;
		public FindByTitle(String title) {
			this.title = title;
		}
		
		public boolean apply(Book book) {
			return book.getTitle().equalsIgnoreCase(title);
		}
	}

	/**
	 * Obtengo la lista por título (podría añadir a ConsultaDB, pero no es
	 * bueno aumentar el API sólo por los tests)
	 * @param title a buscar
	 * @return list
	 */
	private List<Book> getByTitle(String title) {
		List<Book> books = ImmutableList.copyOf(persistence.getBooks());
		// Obtengo un libro no logo (podría añadirse el método en el interfaz)
		return FluentIterable.from(books).filter(new FindByTitle(title)).toImmutableList();
	}
	
	@Test
	public void testUpdate() {
		List<Book> books_nologo = getByTitle("no logo");
		assertFalse(getByTitle("no logo").isEmpty());
		assertTrue(getByTitle("nologo").isEmpty());
		assertEquals(books_nologo.size(), 1);
		Book book = books_nologo.get(0);
		book.setTitle("nologo");
		assertTrue(getByTitle("no logo").isEmpty());
		assertFalse(getByTitle("nologo").isEmpty());
		persistence.updateBook(book);
		assertTrue(getByTitle("no logo").isEmpty());
		assertFalse(getByTitle("nologo").isEmpty());
	}

}
