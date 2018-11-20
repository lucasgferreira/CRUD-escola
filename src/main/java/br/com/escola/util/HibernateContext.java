package br.com.escola.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.escola.util.HibernateUtil;

public class HibernateContext implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory();
	}
}
