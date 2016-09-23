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

import com.spanish.english.form.CoinsName;
import com.spanish.english.form.NotesName;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotesNameDaoImpl implements NotesNameDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateNotesName(NotesName coinsName) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(coinsName);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<NotesName> getNotesNameList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(NotesName.class);
		
		List<NotesName> list =  c.list();
		Set<NotesName> notesNameList = new HashSet<NotesName>(list);

		tx.commit();
		session.close();
		return notesNameList;
	}

	@Override
	public NotesName getNotesNameById(long id) {
		Session session;
		NotesName  notesName = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(NotesName.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 notesName = (NotesName)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return notesName;
	}

	@Override
	public boolean deleteNotesName(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(NotesName.class, Id);
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

	@Override
	public Set<NotesName> getNotesNameByCountry(long cID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(NotesName.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", cID));
		
		List<NotesName> list =  c.list();
		Set<NotesName> coinsValueList = new HashSet<NotesName>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

}
