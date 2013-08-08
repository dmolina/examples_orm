package org.uca.gii.mybatis.persistence;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;

public abstract class TestBD {

	public TestBD() {
		super();
	}

	@Before
	public void init() throws IOException {
		PersistenceFactory.setConfig("mybatis-config.xml");
	}

	@After
	public void finish() throws Throwable {
		PersistenceFactory.rollback();
		PersistenceFactory.close();
	}

}