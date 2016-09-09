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

import com.spanish.english.form.CoinsValue;
import com.spanish.english.form.HopperType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinsValueDaoImpl implements CoinsValueDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCoinsValue(CoinsValue coinsValue) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(coinsValue);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CoinsValue> getCoinsValueList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsValue.class);
		
		List<CoinsValue> list =  c.list();
		Set<CoinsValue> coinsValueList = new HashSet<CoinsValue>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

	@Override
	public CoinsValue getCoinsValueById(long id) {
		Session session;
		CoinsValue  coinsValue = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CoinsValue.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 coinsValue = (CoinsValue)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return coinsValue;
	}

	@Override
	public boolean deleteCoinsValue(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CoinsValue.class, Id);
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
	public CoinsValue getLastCoinsValue() {
		Session session=sessionFactory.openSession();
		CoinsValue result = (CoinsValue) session.createQuery("from CoinsValue ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CoinsValue> getCoinsValueListByCoinsType(long ctid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinsValue.class);
		c.createAlias("coinsType", "c");
		c.add(Restrictions.eq("c.id", ctid));
		
		List<CoinsValue> list =  c.list();
		Set<CoinsValue> coinsValueList = new HashSet<CoinsValue>(list);

		tx.commit();
		session.close();
		return coinsValueList;
	}

}
