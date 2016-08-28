package com.spanish.english.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Operator;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EstablishmentDaoImpl implements EstablishmentDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateEstablishment(Establishment establishment) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(establishment);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Establishment> getEstablishmentList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Establishment.class);
		
		List<Establishment> list =  c.list();
		Set<Establishment> establishmentList = new HashSet<Establishment>(list);

		tx.commit();
		session.close();
		return establishmentList;
	}

	@Override
	public Establishment getEstablishmentById(long id) {
		Session session;
		Establishment  establishment = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Establishment.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 establishment = (Establishment)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return establishment;
	}

	@Override
	public boolean deleteEstablishment(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Establishment.class, Id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	}
