package br.com.softgraf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import sun.security.provider.certpath.BuildStep;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	public static final String HIBERNATE_SESSION = "hibernate_session";
	
	static{
		sessionFactory = new AnnotationConfiguration().configure ("br/com/softgraf/util/hibernate.cfg.xml").buildSessionFactory();
		
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	
	

}
