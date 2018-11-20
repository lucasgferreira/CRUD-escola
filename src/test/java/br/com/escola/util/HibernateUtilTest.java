package br.com.escola.util;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import br.com.escola.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	//@Ignore
	public void conectar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
