package org.uca.gii.mybatis.persistence;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.apache.ibatis.logging.Log;
import org.junit.Test;

import com.google.common.collect.Sets;

import org.uca.gii.mybatis.persistence.PersistenceFactory;
import org.uca.gii.mybatis.dao.ConsultaBD;
import org.uca.gii.mybatis.data.Book;

public class TestBooks extends TestBD {
	@Test
	public void testNotEmpty() {
		List<Book> books = PersistenceFactory.getInterfaceDB().getBooks();
		Logger log = LoggerFactory.getLogger(TestBooks.class);
		
		for (Book book : books) {
			log.info(book.toString());
		}
		assertFalse(books.isEmpty());
	}
	
	@Test
	public void testCategories() {
List<Book> books = PersistenceFactory.getInterfaceDB().getBooks();
		
		for (Book book : books) {
			assertNotNull(book.getCategories());
		}
	}
	
	@Test
	public void testByCategories() {
		ConsultaBD interfaceDB;
		
		interfaceDB = PersistenceFactory.getInterfaceDB();
		List<Book> books = interfaceDB.getBooks();
		List<Book> booksEnsayo = interfaceDB.getByCategory("Ensayo");
		assertFalse(booksEnsayo.isEmpty());
		List<Book> booksFantasia = interfaceDB.getByCategory("Fantasia");
		assertFalse(booksFantasia.isEmpty());
		assertEquals(books.size(), booksEnsayo.size()+booksFantasia.size());
		
		Set<Book> booksEnsayoSet = new HashSet(booksEnsayo);
		Set<Book> booksFantasiaSet = new HashSet(booksFantasia);
				
		Logger log = LoggerFactory.getLogger(TestBooks.class);
		Set<Book> differences = Sets.symmetricDifference(booksEnsayoSet, booksFantasiaSet);
		
		assertEquals(differences.size(), books.size());
	}

}