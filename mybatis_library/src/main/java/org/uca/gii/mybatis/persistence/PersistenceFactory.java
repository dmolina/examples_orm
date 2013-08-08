package org.uca.gii.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.uca.gii.mybatis.dao.ConsultaBD;
/**
 * Esta clase permite recuperar los distintos interfaces de conexión con la Base de Datos
 * @author dmolina
 *
 */
public class PersistenceFactory {
	private static final PersistenceFactory persistence = new PersistenceFactory();
	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession session; 
	
	private PersistenceFactory() {
		session = null;
	}
	
	public static void setConfig(String filename) throws IOException {
		Reader reader = Resources.getResourceAsReader(filename);
		sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);		
	}
	
	public static PersistenceFactory getPersistence() {
		return persistence;
	}
	
	public void init() {
			if (session == null) {
				session = sqlSessionFactory.openSession();
			}			
	}
	
	public static void close() {
		if (persistence.session != null) {
			persistence.session.close();
			persistence.session = null;
		}
	}
	@Override
	protected void finalize() throws Throwable {
		if (session != null)
			session.close();
		super.finalize();
	}	
	
	public static ConsultaBD getInterfaceDB() {
		return getPersistence().getConsultaBD();
	}

	public ConsultaBD getConsultaBD() {
		init();
		ConsultaBD consulta= session.getMapper(ConsultaBD.class);		
		return consulta;
	}
	
	public static void rollback() {
		if (persistence.session != null) {
			persistence.session.rollback();
		}
	}

	public static void save() {
		if (persistence.session != null) {
			persistence.session.commit();
		}
		
	}
}