package org.uca.gii.ebean.persistence;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.uca.gii.ebean.dao.ConsultaBD;
import org.uca.gii.ebean.dao.ConsultaBDImpl;

import com.avaje.ebean.Ebean;

public abstract class TestBD {
	public ConsultaBD persistence;

	public TestBD() {
		super();
	}

	@Before
	public void init() throws IOException {
		Ebean.beginTransaction();
		persistence = new ConsultaBDImpl();
	}

	@After
	public void finish() throws Throwable {
		Ebean.rollbackTransaction();
	}

}