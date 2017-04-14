package com.dao;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

@Repository("loginDAO")
public class LoginDAOImp implements LoginDAO {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public boolean checkLogin(int id, String userName) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		// Query using Hibernate Query Language
		String SQL_QUERY = " from Users as o where o.userName=? ";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0, id);
		query.setParameter(1, userName);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}

		session.close();
		return userFound;
	}

}
