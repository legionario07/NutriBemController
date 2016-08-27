package br.com.nutribem.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessao = null;

	/**
	 * 
	 * @return Session do Hibernate
	 */
	public static Session getSession() {

		if (sessao == null) {
			sessao = new Configuration().configure().buildSessionFactory();
		} else {
			return sessao.openSession();
		}

		return sessao.openSession();
	}
}
