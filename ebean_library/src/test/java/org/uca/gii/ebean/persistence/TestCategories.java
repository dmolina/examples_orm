package org.uca.gii.ebean.persistence;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.uca.gii.ebean.dao.ConsultaBD;
import org.uca.gii.ebean.data.Category;
import org.uca.gii.ebean.data.Category;

import com.google.common.collect.Lists;

public class TestCategories extends TestBD {
	@Test
	public void insertCategory() {
		int num_categories =persistence.getCategories().size(); 
		assertTrue(num_categories > 0);
		Category category = new Category("romantica", 13);
		persistence.insertCategory(category);
		assertTrue(persistence.getCategories().size() == num_categories+1);
	}

	@Test
	public void insertCategories() {
		int num_categories =persistence.getCategories().size(); 
		assertTrue(num_categories > 0);
		List<Category> categories = Lists.newLinkedList();
		categories.add(new Category("romantica", 13));
		categories.add(new Category("infantil", 0));
		persistence.insertCategories(categories);
		assertTrue(persistence.getCategories().size() == num_categories+2);
	}

}
