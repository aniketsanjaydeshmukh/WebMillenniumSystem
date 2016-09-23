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

import com.spanish.english.form.BillsName;
import com.spanish.english.form.CoinsName;
import com.spanish.english.form.CoinsValue;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinsNameDaoImpl implements CoinsNameDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCoinsName(CoinsName coinsName) {
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
	public Set<CoinsName> getCoinsNameList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsName.class);
		
		List<CoinsName> list =  c.list();
		Set<CoinsName> billsNameList = new HashSet<CoinsName>(list);

		tx.commit();
		session.close();
		return billsNameList;
	}

	@Override
	public CoinsName getCoinsNameById(long id) {
		Session session;
		CoinsName  billsName = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CoinsName.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 billsName = (CoinsName)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billsName;
	}

	@Override
	public boolean deleteCoinsName(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CoinsName.class, Id);
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
	public Set<CoinsName> getCoinsNameByCountry(long cID) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsName.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", cID));
		
		List<CoinsName> list =  c.list();
		Set<CoinsName> coinsValueList = new HashSet<CoinsName>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

}
